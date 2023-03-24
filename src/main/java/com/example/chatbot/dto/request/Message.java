package com.example.chatbot.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String role;
    private String content;
}
