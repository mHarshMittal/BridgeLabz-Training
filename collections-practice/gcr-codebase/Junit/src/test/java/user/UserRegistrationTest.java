package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private UserRegistration registration;

    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("johnDoe", "john@example.com", "Password123"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("", "john@example.com", "Password123"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("johnDoe", "johnexample.com", "Password123"));
        assertEquals("Invalid email address", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser("johnDoe", "john@example.com", "pass"));
        assertEquals("Password must be at least 8 characters", exception.getMessage());
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser(null, null, null));
    }
}
