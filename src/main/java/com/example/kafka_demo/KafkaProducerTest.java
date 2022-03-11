package com.example.kafka_demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Properties;

public class KafkaProducerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","192.168.127.200:9092,192.168.127.200:9093,192.168.127.200:9094");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer producer = new KafkaProducer<String, String>(props);
        ProducerRecord<String,String> record = new ProducerRecord<String,String>("testTopic","key1","value1");
        ProducerCallBack producerCallBack = new ProducerCallBack();
        producer.send(record,producerCallBack);
    }
}
