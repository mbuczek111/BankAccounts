package bankaccounts;

import java.math.BigDecimal;

public class BankApplication {
    public static void main(String[] args) {
        NationalBank nb = NationalBank.getInstance();

        Account creditAccount = new CreditAccount();
        Account depositAccount = new DepositAccount();

        Bank alior = new Bank("AliorBank");

        alior.addAccount(creditAccount);
        alior.addAccount(depositAccount);

        nb.addBank(alior);

        /* =========TESTING============ */
        System.out.println( alior.getAccount(1));
        System.out.println(nb.getBank("AliorBank"));

        creditAccount.topUp(BigDecimal.valueOf(1000));
        creditAccount.transfer(BigDecimal.valueOf(300), depositAccount);

        creditAccount.applyPercent(BigDecimal.valueOf(0.05));

        System.out.println(nb.getBank("AliorBank"));
        System.out.println(creditAccount.getBalance());
        creditAccount.withdraw(BigDecimal.valueOf(800));
        System.out.println(creditAccount.getBalance());
        creditAccount.transfer(BigDecimal.valueOf(300), depositAccount);
        depositAccount.transfer(BigDecimal.valueOf(300),creditAccount);
        System.out.println(depositAccount.getBalance());
        depositAccount.transfer(BigDecimal.valueOf(300),creditAccount);

        System.out.println(nb.getBank("AliorBank"));

        creditAccount.withdraw(BigDecimal.valueOf(400));
        depositAccount.withdraw(BigDecimal.valueOf(10));

        System.out.println(nb.getBank("AliorBank"));
        System.out.println(creditAccount.getAccountNumber());
        creditAccount.withdraw(BigDecimal.valueOf(285));
        creditAccount.applyPercent(BigDecimal.valueOf(0.1));
        System.out.println(creditAccount.getBalance());
    }
}
