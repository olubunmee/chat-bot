package com.example.chatbot.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDatabase {
    private String id;
    private String response;

}
