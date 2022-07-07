https://spark.apache.org/docs/latest/spark-standalone.html

1. Install local Spark

Download the zip
./sbin/start-master.sh
Check the spark Master
./sbin/start-worker.sh spark://MacBook-Pro-de-Luiz.local:7077

2. ./bin/spark-shell --master spark://localhost:7077 --packages org.apache.sedona:sedona-python-adapter-3.0_2.12:1.2.0-incubating,org.apache.sedona:sedona-viz-3.0_2.12:1.2.0-incubating,org.datasyslab:geotools-wrapper:1.1.0-25.2
