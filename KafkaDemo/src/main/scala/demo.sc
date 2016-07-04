import java.util.Properties
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.clients.producer.KafkaProducer
//import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord

val props = new Properties()
props.put("bootstrap.servers", "192.168.1.11:32768")
props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
props.put("partitioner.class", "org.apache.kafka.clients.producer.internal.Partitioner")
//props.put("producer.type", "async")
//val config = new ProducerConfig(props)

val producer = new KafkaProducer[String, String](props)
val t = System.currentTimeMillis()

val data = new ProducerRecord[String, String]("topic3", 1, t, "test", "test")
println(producer.send(data))

