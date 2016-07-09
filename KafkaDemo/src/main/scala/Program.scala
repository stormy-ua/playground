import scala.io.StdIn.{readLine => readline}

object Program {
  def main (args: Array[String]) {
    while(true){
      print("Enter message:")
      val message = readline()

      val producer = new KafkaProducer
      implicit val serializer = new StringSerializer[String]
      val task = producer.send(message)
      task.run
    }
  }
}
