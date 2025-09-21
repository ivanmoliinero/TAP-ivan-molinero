package bank;

import java.io.Serializable;
import java.util.*;

/**
 * Created by pedro on 9/14/15.
 */
public class Bank implements Serializable {
    private static final long serialVersionUID = 1; // for the version of serialization.

    private String name;
    private Map<String, List<Account>> accountsMap;
    private List<Customer> customers;

    public Bank(String name) {
        customers = new LinkedList<>();
        accountsMap = new HashMap<String, List<Account>>();
        this.name = name;
    }

    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    public void removeCustomer(Customer oldCustomer){
        customers.remove(oldCustomer);
    }
    public List<Customer> getCustomers() { return customers; }

    public void addAccountMap(Account newAccount) {
        if(null == accountsMap.get(newAccount.getOwner().getId())) {
            List<Account> newList = new LinkedList<>();
            newList.add(newAccount);
            accountsMap.put(newAccount.getOwner().getId(), newList);
        }
        else {
            accountsMap.get(newAccount.getOwner().getId()).add(newAccount); // TODO: Add repetition control.
        }
    }
    public void removeAccountMap(Account oldAccount) {
        List<Account> accCost = accountsMap.get(oldAccount.getOwner().getId());
        if(accCost.size() == 1)
            accountsMap.remove(oldAccount.getOwner().getId());
        else
            accCost.remove(oldAccount);
    }
    public List<Account> getAccountsMap() {
        Iterator<List<Account>> it = accountsMap.values().iterator();
        List<Account> result = new LinkedList<>();
        while(it.hasNext()) {
            result.addAll(it.next());
        }

        return result;
    }

    // NOTE: Both method could be optimised to avoid 2 iterations over the accounts and just one by not reusing the method getAccountsMap() implemented.
    public void showAccounts(){
        for(Account a : getAccountsMap()) {
            System.out.println(a);
        }
    }

    public List<Account> orderAccountsByOwner() {
        List<Account> acc = getAccountsMap();
        acc.sort(new AccountOwnerComparator());
        return acc;
    }

    public void orderAccountsByBalance() {
        // it would be the same as the method above with a new Comparator.
    }

    public void revision(){
        for (Account acc:getAccountsMap())
            acc.revision();
    }

    public void lottery() { getAccountsMap().get(new Random().nextInt(accountsMap.size())).deposit(300); }


}
