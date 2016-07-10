import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer => ApacheKafkaProducer, RecordMetadata, Callback, ProducerRecord}
import scalaz.{-\/, \/-, \/}
import scalaz.concurrent.Task

class KafkaProducer extends Producer {

  override def send[K, V](key: K, content: V)(implicit config: KafkaProducerConfig): Task[Unit] = {
    val props = new Properties()
    props.put("bootstrap.servers", config.servers)
    props.put("key.serializer", config.keySerializer.runtimeClass)
    props.put("value.serializer", config.valueSerializer.runtimeClass)
    props.put("partitioner.class", config.partitioner.runtimeClass)

    val producer = new ApacheKafkaProducer[K, V](props)
    val t = System.currentTimeMillis()
    val data = new ProducerRecord[K, V](config.topic, 0, t, key, content)

    //TODO: specify timeout -> load it from the app config
    Task.async(k => producer.send(data, new Callback {
      override def onCompletion(recordMetadata: RecordMetadata, e: Exception): Unit = {
        e match {
          case null => k.apply(\/-())
          case _ => k.apply(-\/(e))
        }
      }
    }))
  }
}