package com.dev.bruno.kafkaConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.dev.bruno.kafkaConsumer.Consumer.MyKafkaConsumer;
import com.dev.bruno.kafkaConsumer.config.KafkaConsumerConfig;
import com.dev.bruno.kafkaConsumer.producer.MyKafkaProducer;
import com.dev.bruno.kafkaConsumer.repository.MessageRepository;

import controller.KafkaController;

@SpringBootApplication
@ComponentScan(basePackageClasses = {KafkaConsumerConfig.class, MyKafkaConsumer.class, KafkaController.class, MyKafkaProducer.class,MessageRepository.class})
public class KafkaConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
		
	}
	
	
	

}
