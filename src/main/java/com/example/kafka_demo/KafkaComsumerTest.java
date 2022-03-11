package com.example.kafka_demo;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Collections;
import java.util.Properties;

public class KafkaComsumerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","192.168.127.200:9092,192.168.127.200:9093,192.168.127.200:9094");
        props.put("group.id","testGroup");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList("testTopic"));
        while (true){
            ConsumerRecords<String, String> records = consumer.poll(100);
            System.out.println(records);
        }
    }
}
