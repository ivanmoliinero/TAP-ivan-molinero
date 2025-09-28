package exercisesSolved.accountsFromTxt;

import exercisesSolved.bank.AccountId;
import exercisesSolved.bank.AccountType;
import exercisesSolved.bank.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pedro on 9/21/15.
 */
public class TokensAccountsStream {

    public static void main(String[] args) throws IOException {

        FileReader fis = new FileReader("accounts.txt");
        BufferedReader dis = new BufferedReader(fis);
        String line;
        int id;
        String owner;
        AccountType type;
        List<AccountId> acc = new LinkedList<>();

        while ((line = dis.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line, ",");
            while(tokens.hasMoreTokens()) {
                acc.add(new AccountId(Integer.parseInt(tokens.nextToken()), tokens.nextToken(), AccountType.valueOf(tokens.nextToken()), Double.parseDouble(tokens.nextToken())));
            }
        }

        dis.close();

        System.out.println("Accounts:");
        System.out.println(acc);

        // Use stream.map to increment the balance of all accounts in 10 euros
        List<AccountId> ex1 = acc.stream().map((AccountId a) -> {
                a.deposit(10.0);
                    return a; // se trata de una function, y hay que devolver la cuenta modificada para hacer el mapeo
                              // uno a uno de cada cuenta en el nuevo stream.
                }
        ).collect(Collectors.toList());

        System.out.println("\nIncremented balance:");
        System.out.println(ex1);

        // Use stream.filter to obtain all account of type IF
        List<AccountId> ex2 = acc.stream().filter(a -> a.getType().equals(AccountType.IF)).collect(Collectors.toList());
        System.out.println("\nIF accounts:");
        System.out.println(ex2);

        // Use stream.max to obtain the account with the highest balance.
        Optional<AccountId> ex3 = acc.stream().max((a, x) -> Double.compare(a.getBalance(), x.getBalance()));
        if(ex3.isPresent()) {
            System.out.println("\nHighest balance:");
            System.out.println(ex3.get());
        }

    }
}
