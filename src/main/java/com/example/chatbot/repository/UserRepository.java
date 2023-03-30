package com.example.chatbot.repository;

import com.example.chatbot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    User findUserById(String id);
}
