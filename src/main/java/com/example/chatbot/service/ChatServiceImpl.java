package com.example.chatbot.service;

import com.example.chatbot.dto.request.ChatRequest;
import com.example.chatbot.dto.response.ChatResponse;
import com.example.chatbot.model.ChatResponseModel;
import com.example.chatbot.model.ResponseDatabase;
import com.example.chatbot.model.User;
import com.example.chatbot.repository.ResponseRepository;
import com.example.chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {
    private final ResponseRepository responseRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    @Value("${OPEN_API_KEY}")
    private String openApiKey;

    @Transactional
    @Override
    public ChatResponse chatGptResponse(String id, ChatRequest request) {
        User user = userRepository.findUserById(id);
        String URL = "https://api.openai.com/v1/chat/completions";

        HttpHeaders header = new HttpHeaders();
        header.add(CONTENT_TYPE, "application/json");
        header.add(AUTHORIZATION, openApiKey);

        HttpEntity<?> httpEntity = new HttpEntity<>(request, header);
        ChatResponseModel response = restTemplate.postForObject(URL, httpEntity, ChatResponseModel.class);

        String content = null;
        if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
            content = response.getChoices().get(0).getText().getContent();
        }

        ResponseDatabase savedResponse = new ResponseDatabase();
        savedResponse.setResponse(content);
        user.setResponseDatabase(savedResponse);
        userRepository.save(user);

        return ChatResponse.builder()
                .response(content)
                .build();
    }
}
