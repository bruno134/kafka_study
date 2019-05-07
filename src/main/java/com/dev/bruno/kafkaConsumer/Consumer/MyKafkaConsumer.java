package com.dev.bruno.kafkaConsumer.Consumer;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.utils.UUIDs;
import com.dev.bruno.kafkaConsumer.entity.KafkaMessage;
import com.dev.bruno.kafkaConsumer.repository.MessageRepository;

@Component
public class MyKafkaConsumer {

	@Autowired
	private MessageRepository messageRepository;
	
	@KafkaListener(topics="test", groupId = "1" )
	public void listen(String message) {
		
		
		
		messageRepository.save(new KafkaMessage(UUIDs.timeBased(),Instant.now().toString() ,message));
		
		
		
		
		System.out.println("Recebi a mensagem: " + message);
		
	}
	
}
