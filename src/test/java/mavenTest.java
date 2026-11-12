
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class mavenTest {

    @Test
    void testInitialBalance() {
        maven account = new maven(new BigDecimal("1000"));
        assertEquals(new BigDecimal("1000"), account.getBalance());
    }

    @Test
    void testDeposit() {
        maven account = new maven(new BigDecimal("1000"));
        account.deposit(new BigDecimal("500"));
        assertEquals(new BigDecimal("1500"), account.getBalance());
    }

    @Test
    void testWithdrawal() {
        maven account = new maven(new BigDecimal("1000"));
        account.withdraw(new BigDecimal("300"));
        assertEquals(new BigDecimal("700"), account.getBalance());
    }

    @Test
    void testDepositAndWithdrawal() {
        maven account = new maven(new BigDecimal("1000"));
        account.deposit(new BigDecimal("500"));
        account.withdraw(new BigDecimal("400"));
        assertEquals(new BigDecimal("1300"), account.getBalance());
    }

    @Test
    void testInsufficientBalance() {
        maven account = new maven(new BigDecimal("1000"));

        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("1500")));
    }

    @Test
    void testZeroDeposit() {
        maven account = new maven(new BigDecimal("1000"));

        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(BigDecimal.ZERO));
    }

    @Test
    void testNegativeDeposit() {
        maven account = new maven(new BigDecimal("1000"));

        assertThrows(IllegalArgumentException.class,
            () -> account.deposit(new BigDecimal("-100")));
    }

    @Test
    void testZeroWithdrawal() {
        maven account = new maven(new BigDecimal("1000"));

        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(BigDecimal.ZERO));
    }

    @Test
    void testNegativeWithdrawal() {
        maven account = new maven(new BigDecimal("1000"));

        assertThrows(IllegalArgumentException.class,
            () -> account.withdraw(new BigDecimal("-200")));
    }

    @Test
    void testMultipleTransactions() {
        maven account = new maven(new BigDecimal("1000"));

        account.deposit(new BigDecimal("500"));
        account.withdraw(new BigDecimal("200"));
        account.deposit(new BigDecimal("300"));
        account.withdraw(new BigDecimal("100"));

        assertEquals(new BigDecimal("1500"), account.getBalance());
    }

    @Test
    void testNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class,
            () -> new maven(new BigDecimal("-500")));
    }
}
