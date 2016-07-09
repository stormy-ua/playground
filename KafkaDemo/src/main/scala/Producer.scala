import scalaz.concurrent.Task

trait Producer {
  def send[A](content: A)(implicit ev: Serializer[A]): Task[Unit]
}