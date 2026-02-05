package com.gabrieldp.ticketing.user.service;

import com.gabrieldp.ticketing.security.Role;
import com.gabrieldp.ticketing.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public User register(String email, String password) {
        validateEmailNotExists(email);

        User user = new User(
                idGenerator.getAndIncrement(),
                email,
                password,
                Role.USER,
                LocalDateTime.now()
        );

        users.add(user);
        return user;
    }

    private void validateEmailNotExists(String email) {
        Optional<User> existingUser = users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }
    }

    public List<User> findAll() {
        return users;
    }
}

