import org.apache.kafka.clients.producer.internals.DefaultPartitioner
import org.apache.kafka.common.serialization.StringSerializer

import scala.io.StdIn.{readLine => readline}
import scala.reflect._

object Program {
  def main (args: Array[String]) {

    //TODO: load properties from application.conf using typesafe config
    implicit val config = new KafkaProducerConfig(
      "192.168.1.11:32768",
      "test",
      "org.apache.kafka.common.serialization.StringSerializer",
      "org.apache.kafka.common.serialization.StringSerializer",
      "org.apache.kafka.clients.producer.internals.DefaultPartitioner"
    )

    while(true){
      print("Enter message:")
      val message = readline()

      try {
        val producer = new KafkaProducer
        val task = producer.send("test_key", message)
        task.run
      }
      catch {
        case e: Exception => println(e)
      }
    }
  }
}
