package bankaccounts;

import java.math.BigDecimal;

public class DepositAccount extends Account {
    @Override
    public void transfer(BigDecimal amount, Account anotherAccount)
    {
        if(this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
            super.transfer(amount,anotherAccount);
        }
        else
            System.out.println("Limit exceeded. The limit is: 0");
    }
    @Override
    public void withdraw(BigDecimal amount)
    {
        if(this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) > 0) {
            super.withdraw(amount);
        }
        else
            System.out.println("Limit exceeded. The limit is: 0");
    }


}
