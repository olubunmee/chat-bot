package com.example.chatbot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private Double confidence;
    private Text text;
    private String finish_reason;
    private Integer index;
}
