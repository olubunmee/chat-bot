package com.example.chatbot.repository;

import com.example.chatbot.dto.response.ChatResponse;
import com.example.chatbot.model.ResponseDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponseRepository extends MongoRepository<ResponseDatabase, String> {
}
