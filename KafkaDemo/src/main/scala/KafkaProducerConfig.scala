import scala.reflect.ClassTag

final class KafkaProducerConfig(
   val servers: String,
   val topic: String,
   val keySerializer: String,
   val valueSerializer: String,
   val partitioner: String)