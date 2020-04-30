package bankaccounts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NationalBank {
    private Set<Bank> banks;

    private static NationalBank NATIONAL_BANK;

    private NationalBank() {
        banks = new HashSet<>();
    }

    public static NationalBank getInstance() {
        if (NATIONAL_BANK == null) {
            NATIONAL_BANK = new NationalBank();
        }
        return NATIONAL_BANK;
    }
    public void addBank(Bank bank)
    {
        banks.add(bank);
    }
    public Bank getBank(String name)
    {
        for (Bank b:banks) {
            if (b.getName().equals(name))
                return b;
        }
        return null;
    }


}
