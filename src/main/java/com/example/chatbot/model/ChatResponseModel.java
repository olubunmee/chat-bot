package com.example.chatbot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponseModel {
    private String id;
    private String object;
    private Long created;
    private String model;
    private Usage usage;
    private List<Choice> choices;
}
