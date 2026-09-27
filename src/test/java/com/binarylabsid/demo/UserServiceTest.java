package com.binarylabsid.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    void getUserDisplayName_knownId_returnsUpperCaseName() {
        String result = userService.getUserDisplayName(1);
        assertEquals("BINARYLABS ID", result);
    }

    @Test
    void getUserDisplayName_unknownId_throwsIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getUserDisplayName(99)
        );
        assertTrue(ex.getMessage().contains("99"));
    }
}
