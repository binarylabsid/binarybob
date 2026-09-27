package com.binarylabsid.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    // ---------------------------------------------------------------
    // Happy-path: known IDs return uppercased name
    // ---------------------------------------------------------------

    @Test
    void getUserDisplayName_knownId_returnsUppercasedName() {
        assertEquals("BINARYLABS ID", userService.getUserDisplayName(1));
    }

    @Test
    void getUserDisplayName_allSeededUsers_returnCorrectNames() {
        assertEquals("TRY ABDI PUTRA",      userService.getUserDisplayName(2));
        assertEquals("SONIA RAHMAWATI",      userService.getUserDisplayName(3));
        assertEquals("ALIZA ABDUL AZIS K",   userService.getUserDisplayName(4));
    }

    // ---------------------------------------------------------------
    // Null-check fix: unknown ID must throw, NOT NullPointerException
    // ---------------------------------------------------------------

    @Test
    void getUserDisplayName_unknownId_throwsIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getUserDisplayName(999)
        );
        assertTrue(ex.getMessage().contains("999"),
                "Exception message should include the missing user ID");
    }

    @Test
    void getUserDisplayName_unknownId_doesNotThrowNullPointerException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> userService.getUserDisplayName(0)
        );
        // Verify NPE is NOT the exception type
        try {
            userService.getUserDisplayName(0);
        } catch (Exception e) {
            assertNotEquals(NullPointerException.class, e.getClass(),
                    "Root cause must not be NullPointerException after the fix");
        }
    }
}
