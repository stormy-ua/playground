trait Serializer[A] {
  def serialize(content: A): String
}

class StringSerializer[A] extends Serializer[A] {
  override def serialize(content: A) = content.toString
}