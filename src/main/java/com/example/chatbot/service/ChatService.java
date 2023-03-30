package com.example.chatbot.service;

import com.example.chatbot.dto.request.ChatRequest;
import com.example.chatbot.dto.response.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    ChatResponse chatGptResponse(String id, ChatRequest request);
}
