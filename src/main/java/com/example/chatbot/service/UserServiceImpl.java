package com.example.chatbot.service;

import com.example.chatbot.model.User;
import com.example.chatbot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String register(String email) {
        if (userRepository.existsByEmail(email))
            throw new RuntimeException("User already exists");
        User user = new User();
        user.setEmail(email);
        userRepository.save(user);
        return "Registration Successful";
    }
}
