import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import geojson.Feature;
import org.apache.sedona.core.formatMapper.GeoJsonReader;
import org.apache.sedona.core.spatialRDD.SpatialRDD;
import org.apache.sedona.sql.utils.Adapter;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;

public class Buffer {

    SparkSession sparkSession;
    public Buffer(SparkSession sparkSession){
        this.sparkSession=sparkSession;
    }

    private void readLargeJson(String url, String output) throws IOException {
        Path filePath = Path.of(output);

        try(FileOutputStream outputStream = new FileOutputStream(filePath.toFile())){
            try (
                    InputStream inputStream = new URL(url).openStream();
                    JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
            ) {
                reader.beginObject();
                while(reader.hasNext()) {

                    String features = reader.nextName();

                    if("features".equals(features)) {

                        reader.beginArray();
                        while (reader.hasNext()) {
                            Feature feature = new Gson().fromJson(reader, Feature.class);
                            byte[] strToBytes = (new Gson().toJson(feature)).getBytes();
                            outputStream.write(strToBytes);
                        }
                        reader.endArray();
                    } else {
                        reader.skipValue(); //avoid some unhandle events
                    }
                }
                reader.endObject();
            }
        }

    }

    public org.locationtech.jts.geom.Polygon calculateBuffer(String url) throws IOException {

        String inputLocation = "data.json";
        readLargeJson(url, inputLocation);

        boolean allowTopologyInvalidGeometries = true;
        boolean skipSyntaxInvalidGeometries = true;
        SpatialRDD<Geometry> spatialRDD = GeoJsonReader.readToGeometryRDD(new JavaSparkContext(sparkSession.sparkContext()), inputLocation, allowTopologyInvalidGeometries, skipSyntaxInvalidGeometries);

        Dataset<Row> df = Adapter.toDf(spatialRDD, sparkSession);
        df.createOrReplaceTempView("spatialRDD");

        Dataset<Row> results = sparkSession.sql("SELECT ST_Area(ST_Buffer(spatialRDD.geometry, 1)), ST_Buffer(spatialRDD.geometry, 1) FROM spatialRDD");
        results.show();

        Polygon result=null;

        for(Row r:results.collectAsList()){
            result= (Polygon) r.get(1);
        }

        return result;
    }
}
