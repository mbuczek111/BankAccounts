package bankaccounts;

import java.math.BigDecimal;

public class CreditAccount extends Account {
    BigDecimal limit=BigDecimal.valueOf(-100);

    @Override
    public void transfer(BigDecimal amount, Account anotherAccount)
    {
        if(this.getBalance().subtract(amount).compareTo(limit) > 0) {
            this.setBalance(this.getBalance().subtract(amount));
            anotherAccount.setBalance(anotherAccount.getBalance().add(amount));        }
        else
            System.out.println("Limit exceeded. The limit is: " + limit);
    }
    @Override
    public void withdraw(BigDecimal amount)
    {
        if(this.getBalance().subtract(amount).compareTo(limit) > 0) {
            this.setBalance(this.getBalance().subtract(amount));
        }
        else
            System.out.println("Limit exceeded. The limit is: " + limit);
    }
    @Override
    public void applyPercent(BigDecimal percent)
    {
        if(this.getBalance().compareTo(BigDecimal.ZERO) < 0)
        {
            this.setBalance(this.getBalance().multiply(percent.add(BigDecimal.ONE)));
        }
    }

}
