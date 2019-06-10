package com.github.lxdeng.kafka.t1;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {
	public static void main(String[] args) {
		//System.out.println("demo");
		
		// create Producer properties
		Properties props = new Properties();
		
		String bootstrapServers = "localhost:9092";
		//props.setProperty("boostrap.servers", bootstrapServers);
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
				
		//props.setProperty("key.serializer", StringSerializer.class.getName());
		//props.setProperty("value.serializer", StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		
		// create a producer record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("test2", "hello4");
		
		//async send data
		producer.send(record);
		producer.flush();
		
		producer.close();
	}
}
