package exercisesSolved.bank;

import java.io.Serializable;


/**
 * Created by pedro on 9/14/15.
 */
public class AccountId implements Serializable {
    private int id;
    private double balance;
    private String owner;
    private double interest;
    private AccountType type;

    public AccountId(int id, String owner, AccountType type, double balance) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount) throws NoMoney {
        if (amount>balance)
            throw new NoMoney();
        else
            balance = balance - amount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    public double getInterest(){
        return interest;
    }
    public double getCommission(){
        return 10;
    }
    public void revision(){
        balance = balance + balance * getInterest() - getCommission();
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", owner=" + owner +
                '}';
    }
}
