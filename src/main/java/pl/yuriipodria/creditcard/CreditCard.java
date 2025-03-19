package pl.yuriipodria.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    public static final int CREDIT_THRESHOLD = 100;
    private final String cardNumber;
    private BigDecimal initialCredit;
    private BigDecimal balance;

    public CreditCard(String cardNumber ) {
        this.cardNumber = cardNumber;
    }

    public String getNumber() {
        return cardNumber;
    }
    
    public BigDecimal getInitialCredit() { return initialCredit; }

    public void assignCredit(BigDecimal initialCredit) {
        if (isCreditBelowThreshold(initialCredit)) {
            throw new CreditBelowThresholdException();
        }

        if (this.initialCredit != null) {
            throw new CreditCantBeAssignedTwiceException();
        }

        this.initialCredit = initialCredit;
        this.balance = initialCredit;
    }

    private static boolean isCreditBelowThreshold(BigDecimal credit) {
        return credit.compareTo(BigDecimal.valueOf(CREDIT_THRESHOLD)) < 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        if (canAfford(money)) {
            throw new NotEnoughMoneyException();
        }

        this.balance = this.balance.subtract(money);
    }

    private boolean canAfford(BigDecimal money) {
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) < 0;
    }
}
