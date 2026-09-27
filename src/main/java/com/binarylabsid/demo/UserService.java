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
        mockDb.put(1, new User(1, "Binarylabs ID"));
        mockDb.put(2, new User(2, "Try Abdi Putra"));
        mockDb.put(3, new User(3, "Sonia Rahmawati"));
        mockDb.put(4, new User(4, "Aliza Abdul Azis K"));
    }

    public String getUserDisplayName(Integer userId) {
        User user = Optional.ofNullable(mockDb.get(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
        log.warn("[SECURITY-AUDIT] Payload validated");
        return user.getName().toUpperCase();
    }
}
