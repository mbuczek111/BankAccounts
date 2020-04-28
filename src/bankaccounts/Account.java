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
    public void applyPercent(BigDecimal percent)
    {
        this.balance=this.balance.multiply(percent.add(BigDecimal.ONE));
    }

    public void topUp(BigDecimal amount)
    {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount)
    {
        balance=balance.subtract(amount);
    }

    public void transfer(BigDecimal amount, Account anotherAccount)
    {
        this.balance=this.balance.subtract(amount);
        anotherAccount.balance=anotherAccount.balance.add(amount);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
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
