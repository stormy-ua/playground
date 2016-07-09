import java.util.Properties
import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer => ApacheKafkaProducer}
import scalaz.concurrent.Task

class KafkaProducer extends Producer {

  override def send[A](content: A)(implicit serializer: Serializer[A]): Task[Unit] = {
    val properties = getProperties
    val message = serializer.serialize(content)

    val producer = new ApacheKafkaProducer[String, String](properties)
    val t = System.currentTimeMillis()
    val data = new ProducerRecord[String, String]("topic3", 0, t, "test", message)
    val futureRecord = producer.send(data)

    //TODO: specify timeout -> load it from the app config
    Task { futureRecord.get() }
  }

  def getProperties: Properties = {
    //TODO: load properties from application.conf using typesafe config
    val props = new Properties()
    props.put("bootstrap.servers", "192.168.1.11:32768")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner")
    props
  }
}