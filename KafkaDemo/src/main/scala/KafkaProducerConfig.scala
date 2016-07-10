import scala.reflect.ClassTag

final class KafkaProducerConfig(
   val servers: String,
   val topic: String,
   val keySerializer: ClassTag[_],
   val valueSerializer: ClassTag[_],
   val partitioner: ClassTag[_])