package pl.yuriipodria.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditTests {
    @Test
    void cardIsIdentifiedWithNumber() {
        //Arrange    // Given     // Input
        var number = "1234-5678";

        //Act        // When      // Action
        var card = new CreditCard(number);

        //Assert     // Then      // Output
        assertEquals(
                "1234-5678",
                card.getNumber()
        );
    }

    @Test
    void assignInitialCredit() {
        var card = new CreditCard("1234-5678");

        card.assignCredit(BigDecimal.valueOf(1500));

        assertEquals(
                BigDecimal.valueOf(1500),
                card.getBalance()
        );
    }

    @Test
    void limitCantBeLowerThanThreshold() {
        var card = new CreditCard("1234-5678");

        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Exception should be thrown");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void limitCantBeLowerThanThresholdV2() {
        var card = new CreditCard("1234-5678");

        assertThrows(CreditBelowThresholdException.class, () -> card.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void creditCantBeAssignedTwice() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(123424));

        assertThrows(
                CreditCantBeAssignedTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(454355))
        );
    }

    @Test
    void itAllowsToWithdrawSomeMoney() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1500));

        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(
                BigDecimal.valueOf(1400),
                card.getBalance()
        );
    }

    @Test
    void cantWithdrawWhenNotEnoughMoney() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1500));

        card.withdraw(BigDecimal.valueOf(1000));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.withdraw(BigDecimal.valueOf(1000))
        );
    }

    @Test
    void CanBeWithdrawnWhenSpendingTotalCredit() {
        var card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1500));

        assertDoesNotThrow(
                () -> card.withdraw(BigDecimal.valueOf(1000))
        );
    }
}
