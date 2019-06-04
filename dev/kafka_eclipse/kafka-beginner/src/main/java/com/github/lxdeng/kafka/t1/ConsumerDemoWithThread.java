package com.github.lxdeng.kafka.t1;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemoWithThread {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ConsumerDemoWithThread.class);
		
		String bootstrapServers = "localhost:9092";		
		String topic = "test2";
		String groupId = "myApp5";
		
		CountDownLatch latch = new CountDownLatch(1);
		
		logger.info("Creating consumer thread");
		ConsumerRunnable cr = new ConsumerRunnable(bootstrapServers, groupId, topic, latch);
		Thread conThread = new Thread(cr);
		conThread.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread( () -> {
				logger.info("Enter shutdown hook");
				cr.shutdown();   // ctl+c or kill -2 <pid> nnm
				
				//
				//try {
				//	Thread.sleep(1000); // when the hook is done execution, the program exits, the main thread may not finish
				//} catch(InterruptedException e) {
				//	logger.error("interupted " + e);
				//}
				
				try {
					latch.await();
				} catch(InterruptedException e) {
					logger.error("interupted " + e);
				}
				
				logger.info("hook exit");
				
			}
		));
		
		try {
			latch.await();
		} catch(InterruptedException e) {
			logger.error("interupted " + e);
		} finally {
			logger.info("app is closing");
		}
		
		logger.info("main exit");
	}
}

class ConsumerRunnable implements Runnable {	
	private CountDownLatch latch;
	private String bootstrapServers;
	private String groupId;
	private String topic;
	private KafkaConsumer<String, String> consumer;
	private Logger logger = LoggerFactory.getLogger(ConsumerRunnable.class);

	public ConsumerRunnable(
			String bootstrapServers,
			String groupId,
			String topic,
			CountDownLatch latch) {
		
		this.latch = latch;
		this.bootstrapServers = bootstrapServers;
		this.groupId = groupId;
		this.topic = topic;
		
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		//create consumer
		consumer = new KafkaConsumer<>(props);
		
		// subscribe consumer to topic(s)
		consumer.subscribe(Collections.singleton(topic));
	}
	
	@Override
	public void run() {
		
		try {
			// poll for data
			while(true) {
				ConsumerRecords<String, String> records = 
						consumer.poll(Duration.ofMillis(100));
				
				for (ConsumerRecord<String, String> record : records) {
					logger.info("key: " + record.key() + ", value " + record.value());
					//logger.info("partition: " + record.partition() + ", offset: " + record.offset());
				}
			}
		} catch(WakeupException e) {
			logger.info("Wakup call: Recevied shutdown");
		} finally {
			consumer.close();
			latch.countDown(); // tell main we're done
		}
		
	}
	
	public void shutdown() {
		consumer.wakeup(); // to interrupt consumer.poll()
	}
}
