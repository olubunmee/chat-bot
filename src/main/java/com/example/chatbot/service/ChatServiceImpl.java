package com.example.chatbot.service;

import com.example.chatbot.dto.request.ChatRequest;
import com.example.chatbot.dto.response.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {
    private final RestTemplate restTemplate;
    @Value("${OPEN_API_KEY}")
    private String openApiKey;

    @Override
    public ChatResponse chatGptResponse(ChatRequest request) {
        HttpHeaders header = new HttpHeaders();
        header.add(CONTENT_TYPE, "application/json");
        header.add(AUTHORIZATION, openApiKey);
        HttpEntity<?> httpEntity = new HttpEntity<>(request, header);
        String URL = "https://api.openai.com/v1/chat/completions";
        ResponseEntity<Object> response =
                restTemplate.exchange(URL, POST, httpEntity, Object.class);
        return ChatResponse.builder()
                .response(response)
                .build();
    }
}
