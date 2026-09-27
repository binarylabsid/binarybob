package com.binarylabsid.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final Map<Integer, User> mockDb = new HashMap<>();

    public UserService() {
        mockDb.put(1, new User(1, "Try"));
    }

//    public String getUserDisplayName(Integer userId) {
//        return mockDb.get(userId).getName().toUpperCase();
//    }

    public String getUserDisplayName(Integer userId) {
        return Optional.ofNullable(mockDb.get(userId))
                .map(user -> user.getName().toUpperCase())
                .orElseThrow(() -> {
                    log.error("[SECURITY-AUDIT] Unauthorized access attempt for missing user ID: {}", userId);
                    return new UserNotFoundException("User not found");
                });
    }
}
