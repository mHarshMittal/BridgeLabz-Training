package bankaccount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program acc = new Program(100);
        acc.deposit(50);
        assertEquals(150, acc.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program acc = new Program(100);
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> acc.deposit(-20)
        );
        assertEquals("Deposit amount cannot be negative", ex.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program acc = new Program(200);
        acc.withdraw(50);
        assertEquals(150, acc.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program acc = new Program(100);
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> acc.withdraw(200)
        );
        assertEquals("Insufficient funds.", ex.getMessage());
    }
}

