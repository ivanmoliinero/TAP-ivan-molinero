package bank;

public class UseBankMap {
    public static void main(String[] args) {
        Customer c1 = new Customer("1","pedro");
        Customer c2 = new Customer("2","pep");
        Customer c3 = new Customer("3","pau");

        Account a1 = new CheckingAccount(90,c1);
        Account a2 = new SaveAccount(100,c2);
        Account a3 = new InvestFund(10,c3);
        Account a4 = new BonusAccount(20,c3);

        Bank b1 = new Bank("TAP");
        b1.addAccountMap(a1);
        b1.addAccountMap(a2);
        b1.addAccountMap(a3);
        b1.addAccountMap(a4);

        System.out.println("List of accounts:");
        b1.showAccounts();

        // Add another account to pedro.
        b1.addAccountMap(new Account(1000, c1));
        System.out.println("\nAnother account to Pedro:");
        b1.showAccounts();

        // Remove the initial account from Pedro and remove Pep's account.
        b1.removeAccountMap(a1);
        b1.removeAccountMap(a2);
        System.out.println("\nRemove the initial account from Pedro and remove Pep's account:");
        b1.showAccounts();

        // Apply the lottery system to one of the accounts
        System.out.println("\nAppliance of the lottery system:\nBefore the lottery:");
        b1.showAccounts();
        b1.lottery();
        System.out.println("\nAfter the lottery:");
        b1.showAccounts();

        // Order by owner
        System.out.println("\nAccounts ordered by owner:");
        System.out.println(b1.orderAccountsByOwner());
    }
}
