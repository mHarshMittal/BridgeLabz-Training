package divisionutil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisionUtilTest {

    DivisionUtil util = new DivisionUtil();

    @Test
    void testDivideNormal() {
        assertEquals(5, util.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> util.divide(10, 0));
    }
}
