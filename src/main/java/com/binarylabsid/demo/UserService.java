package com.binarylabsid.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Integer, User> mockDb = new HashMap<>();

    public UserService() {
        mockDb.put(1, new User(1, "Try"));
    }

    public String getUserDisplayName(Integer userId) {
        return mockDb.get(userId).getName().toUpperCase();
    }
}
