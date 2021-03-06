package bankaccounts;

import java.math.BigDecimal;

public class DepositAccount extends Account {
    @Override
    public void transfer(BigDecimal amount, Account anotherAccount)
    {
        if(this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            this.setBalance(this.getBalance().subtract(amount));
            anotherAccount.setBalance(anotherAccount.getBalance().add(amount));
        }
        else
            System.out.println("Limit exceeded. The limit is: 0");
    }
    @Override
    public void withdraw(BigDecimal amount)
    {
        if(this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            this.setBalance(this.getBalance().subtract(amount));
        }
        else
            System.out.println("Limit exceeded. The limit is: 0");
    }
    @Override
    public void applyPercent(BigDecimal percent)
    {
        if(this.getBalance().compareTo(BigDecimal.ZERO) >= 0)
        {
            this.setBalance(this.getBalance().multiply(percent.add(BigDecimal.ONE)));
        }
    }


}
