package com.github.lxdeng.kafka.t1;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemo {
	public static void main(String[] args) {
		System.out.println("demo");
		final Logger logger = LoggerFactory.getLogger(ConsumerDemo.class);
		
		Properties props = new Properties();
		
		
		String bootstrapServers = "localhost:9092";
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		
		String groupId = "myApp5";
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		//create consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props); 
		
		String topic = "test2";
		
		// subscribe consumer to topic(s)
		consumer.subscribe(Collections.singleton(topic));
		
		// poll for data
		while(true) {
			ConsumerRecords<String, String> records = 
					consumer.poll(Duration.ofMillis(100));
			
			for (ConsumerRecord<String, String> record : records) {
				logger.info("key: " + record.key() + ", value " + record.value());
				//logger.info("partition: " + record.partition() + ", offset: " + record.offset());
			}
		}
		
	}
}
