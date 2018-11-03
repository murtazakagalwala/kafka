
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumer {

    public static void main(String[] args)
{
    Properties  props=new Properties();

    props.setProperty("bootstrap.servers","192.168.99.100:9092");
    props.setProperty("key.deserializer", StringDeserializer.class.getName());
    props.setProperty("value.deserializer",StringDeserializer.class.getName());
    props.setProperty("group.id","group1");
    props.setProperty("auto.commit.interval.ms","500");
    props.setProperty("auto.offset.reset","earliest");
    org.apache.kafka.clients.consumer.KafkaConsumer<String, String> kc=new org.apache.kafka.clients.consumer.KafkaConsumer(props);
    kc.subscribe(Arrays.asList("third_topic"));

    while(true){

        ConsumerRecords<String,String> cr=kc.poll(1000);
        for(ConsumerRecord<String,String> crr:cr){
            System.out.println( crr.value()+"has key "+crr.key()+" has partition "+crr.partition());
        }
    }

}

}
