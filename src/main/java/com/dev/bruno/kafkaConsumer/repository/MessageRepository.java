package com.dev.bruno.kafkaConsumer.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.dev.bruno.kafkaConsumer.entity.KafkaMessage;

@Repository
public interface MessageRepository extends CassandraRepository<KafkaMessage,UUID>{

}
