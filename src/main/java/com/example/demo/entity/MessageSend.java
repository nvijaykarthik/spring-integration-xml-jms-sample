package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.messaging.Message;

@Entity
@Table(name="MessageSend")

public class MessageSend {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Lob
	@Column(name="Message")
	String payload;
	
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload=payload;
	}
	
	public MessageSend() { 
		}
	

	public MessageSend(String message) {
		super();

		this.payload=message;
	}

}
