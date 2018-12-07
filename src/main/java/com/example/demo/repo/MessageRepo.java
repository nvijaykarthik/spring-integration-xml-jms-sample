package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MessageSend;

public interface MessageRepo extends JpaRepository<MessageSend, String> {

}
