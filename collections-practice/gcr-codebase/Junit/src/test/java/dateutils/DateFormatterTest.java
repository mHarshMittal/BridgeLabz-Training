package dateutils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    private DateFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new DateFormatter();
    }

    @Test
    void testValidDate() {
        String input = "2026-01-30";
        String expected = "30-01-2026";
        assertEquals(expected, formatter.formatDate(input));
    }

    @Test
    void testInvalidDateFormat() {
        String invalidDate = "30/01/2026";
        assertThrows(DateTimeParseException.class, () -> formatter.formatDate(invalidDate));
    }

    @Test
    void testNullDate() {
        assertThrows(NullPointerException.class, () -> formatter.formatDate(null));
    }

    @Test
    void testAnotherValidDate() {
        String input = "2020-12-05";
        String expected = "05-12-2020";
        assertEquals(expected, formatter.formatDate(input));
    }
}
