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
import java.util.concurrent.ExecutionException;

public class ProducerDemoKeys {
	public static void main(String[] args) {
		//System.out.println("demo");
		
		final Logger logger = LoggerFactory.getLogger(ProducerDemoKeys.class);
		
		// create Producer properties
		Properties props = new Properties();
		
		String bootstrapServers = "localhost:9092";
		//props.setProperty("boostrap.servers", bootstrapServers);
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.setProperty("key.serializer", StringSerializer.class.getName());
		props.setProperty("value.serializer", StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		
		String topic = "test2"; 
		for (int i = 0; i < 5; i++) {
			String value = "helloworld " + i;
			String key = "id_" + i;   // msgs of the same keys go to the same partition
			
			logger.info("key=" + key);
			
			// create a producer record
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
			
			try {
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
				}).get(); // block send() to make it sync, don't do it in production
			} catch (ExecutionException eEx) {
				
			} catch (InterruptedException intEx) {
				
			}
		}
		
		producer.flush();
		
		producer.close();
	}
}
