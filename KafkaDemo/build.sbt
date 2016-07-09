name := "KafkaDemo"

version := "1.0"

scalaVersion := "2.11.8"


//libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "0.10.0.0"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.10.+"
libraryDependencies += "log4j" % "log4j" % "1.2.17"
libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "org.scalaz.stream" %% "scalaz-stream" % "0.8"