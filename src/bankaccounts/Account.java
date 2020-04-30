package bankaccounts;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {
    private int accountNumber;
    private BigDecimal balance=null;

    private static int lastAccountNumber;

    public Account() {
        balance = BigDecimal.ZERO;
        accountNumber = ++lastAccountNumber;
    }
    public abstract void applyPercent(BigDecimal percent);

    public void topUp(BigDecimal amount)
    {
        balance = balance.add(amount);
    }

    public abstract void withdraw(BigDecimal amount);

    public abstract void transfer(BigDecimal amount, Account anotherAccount);

    public int getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }
}
