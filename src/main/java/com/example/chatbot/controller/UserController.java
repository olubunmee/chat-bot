package com.example.chatbot.controller;

import com.example.chatbot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/chat-bot")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user-register")
    public ResponseEntity<?> registerUser(@RequestBody String email) {
        return ResponseEntity.ok(userService.register(email));
    }
}
