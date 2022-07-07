
import leaf.Operation;
import org.apache.sedona.sql.utils.SedonaSQLRegistrator;
import org.apache.sedona.viz.core.Serde.SedonaVizKryoRegistrator;
import org.apache.spark.SparkConf;
import org.apache.spark.serializer.KryoSerializer;
import org.apache.spark.sql.SparkSession;
import org.locationtech.jts.geom.Polygon;

import java.io.IOException;

public class Main {

    static SparkSession sparkSession;

    public static void main(String[] args) throws IOException, InterruptedException {
        SparkConf sconf = new SparkConf()
                .set("spark.serializer", KryoSerializer.class.getName()) // org.apache.spark.serializer.KryoSerializer
                .set("spark.kryo.registrator", SedonaVizKryoRegistrator.class.getName() )
                .setJars(new String[]{
                        ".m2/repository/org/apache/sedona/sedona-core-3.0_2.12/1.2.0-incubating/sedona-core-3.0_2.12-1.2.0-incubating.jar",
                        ".m2/repository/org/apache/sedona/sedona-viz-3.0_2.12/1.2.0-incubating/sedona-viz-3.0_2.12-1.2.0-incubating.jar",
                        ".m2/repository/org/datasyslab/geotools-wrapper/1.1.0-25.2/geotools-wrapper-1.1.0-25.2.jar",
                        ".m2/repository/org/apache/sedona/sedona-python-adapter-3.0_2.12/1.2.0-incubating/sedona-python-adapter-3.0_2.12-1.2.0-incubating.jar"})
                .setMaster("spark://MacBook-Pro-de-Luiz.local:7077");

        sparkSession = SparkSession
                .builder()
                .appName("Simple Application")
                .config(sconf)
                .getOrCreate();

        SedonaSQLRegistrator.registerAll(sparkSession);

        Buffer buffer = new Buffer(sparkSession);
        Leaf leaf = new Leaf("<CHANGE-IT>", "<CHANGE-IT>");

        String token = leaf.authenticate();

        for(Operation operation : leaf.getStandardGeoJSON(token)){
            Polygon polygon = buffer.calculateBuffer(operation.getStandardGeojson());
            System.out.println(polygon.toString());
        }

        sparkSession.stop();
    }
}
