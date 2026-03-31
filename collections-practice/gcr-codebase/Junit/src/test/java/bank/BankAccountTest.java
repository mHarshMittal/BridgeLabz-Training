package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000); // initial balance 1000
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance(), "Balance should increase by deposit amount");
    }

    @Test
    void testWithdrawSufficientFunds() {
        boolean success = account.withdraw(400);
        assertTrue(success, "Withdrawal should succeed when funds are sufficient");
        assertEquals(600, account.getBalance(), "Balance should decrease by withdrawal amount");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        boolean success = account.withdraw(1200);
        assertFalse(success, "Withdrawal should fail when funds are insufficient");
        assertEquals(1000, account.getBalance(), "Balance should remain unchanged");
    }

    @Test
    void testMultipleTransactions() {
        account.deposit(200);
        account.withdraw(500);
        assertEquals(700, account.getBalance(), "Balance should reflect multiple transactions");
    }
}
