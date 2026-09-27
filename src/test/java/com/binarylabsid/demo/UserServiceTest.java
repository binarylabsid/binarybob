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
    void getUserDisplayName_knownUser_returnsUppercaseName() {
        String result = userService.getUserDisplayName(1);
        assertEquals("BINARYLABS ID", result);
    }

    @Test
    void getUserDisplayName_unknownUser_throwsIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getUserDisplayName(999)
        );
        assertTrue(ex.getMessage().contains("999"));
    }

    @Test
    void getUserDisplayName_nullUserId_throwsIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> userService.getUserDisplayName(null)
        );
    }
}
