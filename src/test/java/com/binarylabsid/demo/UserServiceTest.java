package com.binarylabsid.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    // --- Happy path ---

    @Test
    void getUserDisplayName_knownId_returnsUpperCaseName() {
        assertThat(userService.getUserDisplayName(1)).isEqualTo("BINARYLABS ID");
    }

    @Test
    void getUserDisplayName_allSeededUsers_returnCorrectNames() {
        assertThat(userService.getUserDisplayName(2)).isEqualTo("TRY ABDI PUTRA");
        assertThat(userService.getUserDisplayName(3)).isEqualTo("SONIA RAHMAWATI");
        assertThat(userService.getUserDisplayName(4)).isEqualTo("ALIZA ABDUL AZIS K");
    }

    // --- Incident regression: NullPointerException on unknown userId ---

    @Test
    void getUserDisplayName_unknownId_throwsNoSuchElementException() {
        assertThatThrownBy(() -> userService.getUserDisplayName(999))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("999");
    }

    @Test
    void getUserDisplayName_nullId_throwsNoSuchElementException() {
        assertThatThrownBy(() -> userService.getUserDisplayName(null))
                .isInstanceOf(NoSuchElementException.class);
    }
}
