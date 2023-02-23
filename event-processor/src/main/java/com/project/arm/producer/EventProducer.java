package com.project.arm.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class EventProducer {
    private static final Logger logger = LoggerFactory.getLogger(EventProducer.class.getName());
    private KafkaProducer<String, String> producer;
    private Properties configure(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }

    public void initializeProducer(){
        producer = new KafkaProducer<>(configure());
    }

    public void addRecord(String key, String value){
        logger.info("adding record");
        producer.send(new ProducerRecord<>(key, value));
    }
}
