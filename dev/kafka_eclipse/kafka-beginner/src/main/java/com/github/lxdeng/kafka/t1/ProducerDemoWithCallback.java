package com.github.lxdeng.kafka.t1;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoWithCallback {
	public static void main(String[] args) {
		//System.out.println("demo");
		
		final Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);
		
		// create Producer properties
		Properties props = new Properties();
		
		String bootstrapServers = "localhost:9092";
		//props.setProperty("boostrap.servers", bootstrapServers);
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.setProperty("key.serializer", StringSerializer.class.getName());
		props.setProperty("value.serializer", StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		
		
		for (int i = 0; i < 10; i++) {
			// create a producer record
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("test2", "hello" + i);
			
			//async send data
			producer.send(record, new Callback() {
				public void onCompletion(RecordMetadata metadata, Exception ex) {
					// executes every time a record is successfully sent or an exception is thrown
					if (ex == null) {
						logger.info("Received metadata: topic=" + metadata.topic() +
									"\n partition=" + metadata.partition() +
									"\n offset=" + metadata.offset());
					} else {
						logger.error(ex.toString());
					}
				}
			});
			
		}
		
		producer.flush();
		
		producer.close();
	}
}
