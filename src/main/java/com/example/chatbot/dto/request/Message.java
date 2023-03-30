package com.example.chatbot.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String role = "user";
    private String content;
}
