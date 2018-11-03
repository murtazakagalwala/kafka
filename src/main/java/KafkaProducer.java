import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class KafkaProducer {

    public static void main(String[] args)
{
    Properties  props=new Properties();

    props.setProperty("bootstrap.servers","192.168.99.100:9092");
    props.setProperty("key.serializer", StringSerializer.class.getName());
    props.setProperty("value.serializer",StringSerializer.class.getName());
    props.setProperty("acks","-1");
    props.setProperty("retries","3");
    props.setProperty("linger.ms","1000");
    Producer<String,String> producer=new org.apache.kafka.clients.producer.KafkaProducer<String,String>(props);

   // ProducerRecord<String,String> pr=new ProducerRecord<String, String>("first_topc","3","messagetest");
    //producer.send(pr);


    for(int key=0;key<10;key++){
        ProducerRecord<String,String> pr=new ProducerRecord<String, String>("third_topic",Integer.toString(key),"messagetest"+Integer.toString(key));
        producer.send(pr);
    }
    producer.close();
}

}
