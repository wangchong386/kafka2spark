# kafka2spark

Here we explain how to configure Spark Streaming to receive data from Kafka. 
There are two approaches to this - the old approach using Receivers and Kafka’s high-level API, 
and a new approach (introduced in Spark 1.3) without using Receivers. They have different programming models,
performance characteristics, and semantics guarantees, so read on for more details.
Both approaches are considered stable APIs as of the current version of Spark.
