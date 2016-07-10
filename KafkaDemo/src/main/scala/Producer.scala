import scalaz.concurrent.Task

trait Producer {
  def send[K, V](key: K, content: V)(implicit config: KafkaProducerConfig): Task[Unit]
}