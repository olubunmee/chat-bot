package com.example.chatbot.controller;

import com.example.chatbot.dto.request.ChatRequest;
import com.example.chatbot.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chat-bot")
@AllArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @PostMapping("/send")
    public ResponseEntity<?> sendChat(@RequestBody ChatRequest request){
        return ResponseEntity.ok(chatService.chatGptResponse(request));
    }
}
