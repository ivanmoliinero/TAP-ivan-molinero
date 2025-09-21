package bank;

import java.util.Comparator;

public class AccountOwnerComparator implements Comparator<Account> {
    public int compare(Account a1, Account a2) {
        return a1.getOwner().getName().compareTo(a2.getOwner().getName());
    }
}
