package com.example.portfolio.user.service;

import com.example.portfolio.user.domain.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<?> createUser(User user);

    public ResponseEntity<?> updateUser(Long userId , User user);

    public ResponseEntity<?> findUserById(Long userId);

    public ResponseEntity<?> findAllUser();

    public ResponseEntity<?> deleteUser(Long userId);

    public ResponseEntity<?> login(String email, String password);
}
