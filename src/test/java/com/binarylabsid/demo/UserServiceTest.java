package com.binarylabsid.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    void whenUserNotFound_thenThrowResourceNotFoundException() {
        // Test ini memastikan bahwa mengecek ID "99" akan melempar Exception yang benar
        assertThrows(UserNotFoundException.class, () -> userService.getUserDisplayName(99));
    }
}