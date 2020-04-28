package bankaccounts;

import java.math.BigDecimal;

public class CreditAccount extends Account {
    BigDecimal limit=BigDecimal.valueOf(-100);

    @Override
    public void transfer(BigDecimal amount, Account anotherAccount)
    {
        if(this.getBalance().subtract(amount).compareTo(limit) > 0) {
            super.transfer(amount,anotherAccount);
        }
        else
            System.out.println("Limit exceeded. The limit is: " + limit);
    }
    @Override
    public void withdraw(BigDecimal amount)
    {
        if(this.getBalance().subtract(amount).compareTo(limit) > 0) {
            super.withdraw(amount);
        }
        else
            System.out.println("Limit exceeded. The limit is: " + limit);
    }

}
