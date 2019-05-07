package com.dev.bruno.kafkaConsumer.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import org.springframework.data.cassandra.core.cql.Ordering;

@Table("kmessages")
public class KafkaMessage {

	@PrimaryKeyColumn(name = "id", 
			          ordinal = 0, 
			          type = PrimaryKeyType.CLUSTERED, 
			          ordering = Ordering.DESCENDING)
	private UUID id;
	
	@PrimaryKeyColumn(name = "date", 
			          ordinal = 0, 
			          type = PrimaryKeyType.PARTITIONED)
	private String date;

	@Column
	private String payloadMessage = new String();
	
	
	

	public KafkaMessage(UUID id, String date, String payloadMessage) {
		super();
		this.id = id;
		this.date = date;
		this.payloadMessage = payloadMessage;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPayloadMessage() {
		return payloadMessage;
	}

	public void setPayloadMessage(String payloadMessage) {
		this.payloadMessage = payloadMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((payloadMessage == null) ? 0 : payloadMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KafkaMessage other = (KafkaMessage) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (payloadMessage == null) {
			if (other.payloadMessage != null)
				return false;
		} else if (!payloadMessage.equals(other.payloadMessage))
			return false;
		return true;
	}
	
	

}
