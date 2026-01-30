package security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        String password = "StrongPass1";
        assertTrue(validator.isValid(password), "Password should be valid");
    }

    @Test
    void testPasswordTooShort() {
        String password = "S1hort";
        assertFalse(validator.isValid(password), "Password should be invalid due to length");
    }

    @Test
    void testPasswordNoUppercase() {
        String password = "weakpass1";
        assertFalse(validator.isValid(password), "Password should be invalid due to missing uppercase");
    }

    @Test
    void testPasswordNoDigit() {
        String password = "NoDigitPass";
        assertFalse(validator.isValid(password), "Password should be invalid due to missing digit");
    }

    @Test
    void testPasswordNull() {
        assertFalse(validator.isValid(null), "Null password should be invalid");
    }
}
