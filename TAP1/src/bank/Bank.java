package bank;

import java.io.Serializable;
import java.util.*;

/**
 * Created by pedro on 9/14/15.
 */
public class Bank implements Serializable {
    private static final long serialVersionUID = 1; // for the version of serialization.

    private String name;
    private List<Account> accounts;
    private Map<String, List<Account>> accountsMap;
    private List<Customer> customers;

    public Bank(String name) {
        accounts = new LinkedList<>();
        customers = new LinkedList<>();
        accountsMap = new HashMap<String, List<Account>>();
        this.name = name;
    }

    public void addAccount(Account newAccount){
        accounts.add(newAccount);
    }
    public void removeAccount(Account oldAccount) { accounts.remove(oldAccount); }
    public List<Account> getAccounts(){
        return accounts;
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

    public void showAccounts(){
        for (Account a:accounts)
            System.out.println(a);
    }

    public void revision(){
        for (Account acc:accounts)
            acc.revision();
    }

    public void lottery() { accounts.get(new Random().nextInt()).deposit(300); }


}
