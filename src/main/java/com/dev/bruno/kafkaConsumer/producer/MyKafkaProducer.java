package com.dev.bruno.kafkaConsumer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private String topicName ="test";
	
	public void sendMessage(String msg) {
	    kafkaTemplate.send(topicName, msg);
	}
	    
}
