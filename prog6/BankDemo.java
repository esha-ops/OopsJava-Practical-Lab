
/*
6 Develop a Java program to demonstrate the creation and use of simple user-defined packages
in a banking context.
    1. Create a package accounts containing a class Account to store basic account
        information such as account number, customer name, and balance.
        Include methods to deposit money, withdraw money with balance checking,
        and display account details.
    2. Create another package services containing a class Interest with a method that
        calculates updated balance by applying a fixed interest rate.
    3. Write a main class BankDemo (outside any package) that imports classes from both
       packages.
       Create an account object, perform deposit and withdrawal operations,
       compute interest, and display the updated balance.
*/

import accounts.Account;
import services.Interest;

public class BankDemo {
    public static void main(String[] args) {
        Account account = new Account(1001, "Esha", 10000);

        account.displayDetails();

        account.deposit(2000);
        account.withdraw(1500);

        Interest interest = new Interest();
        double updatedBalance =
                interest.calculateUpdatedBalance(account.getBalance());

        account.updateBalance(updatedBalance);

        System.out.println("Balance after interest: Rs. " + updatedBalance);
        account.displayDetails();
    }
}

