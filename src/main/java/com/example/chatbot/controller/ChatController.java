package com.example.chatbot.controller;

import com.example.chatbot.dto.request.ChatRequest;
import com.example.chatbot.service.ChatService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/chat-bot")
@AllArgsConstructor
@Slf4j
public class ChatController {
    private final ChatService chatService;
    @PostMapping("/chat/{id}")
    public ResponseEntity<?> sendChat(@PathVariable String id, @RequestBody ChatRequest request){
        return ResponseEntity.ok(chatService.chatGptResponse(id, request));
    }
}
