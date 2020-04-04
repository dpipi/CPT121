package java.rmit.cpt121.task_5_1_3;

import java.util.*;

public class AccountTester {
    public static void main(String args[]) {

        int accountCount = 0;
        double balance;

        String accountID, name;
        String answer = "Y";

        Account a;

        Scanner sc = new Scanner(System.in);

        /*** Array used to store up to 10 accounts ***/
        Account[] accounts = new Account[10];

        /*** CODE for part a) goes here ***/
        do {
            // get account ID from user
            System.out.print("Enter account id:");
            accountID = sc.next().toUpperCase();

            // get Name from user
            System.out.print("Enter name:");
            name = sc.next();

            // get balance from user
            System.out.println("Enter balanace");
            balance = sc.nextDouble();

            // ask to user continue
            System.out.println("Continue Y/N:");
            answer = sc.next();

            // create new account object
            a = new Account(accountID, name, balance);

            // store new employee in next
            // position in array
            accounts[accountCount] = a;
            accountCount++;

        } while (answer.equalsIgnoreCase("Y"));

        // CODE for part c) goes here ***

        accounts[0].transfer(accounts[1], 500);
        accounts[1].transfer(accounts[2], 500);

        // print details for all accounts
        // Code for part b) goes here
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayDetails();

        }
        // close scanner on completion
        sc.close();

    }
}