package task_5_2_3;

import java.util.*;

public class AccountTester {
    public static void main(String args[]) {
        String accountID;
        String name;
        int accountCounter = 0;
        double balance;

        Scanner sc = new Scanner(System.in);

        /*** Array used to store up to 10 accounts ***/
        Account[] accounts = new Account[10];

        /*** CODE for part a) goes here ***/
        String answer = "Y"; // set variable for do while loop
        do {

            // ask for accountID
            System.out.print("Enter accountID: ");
            accountID = sc.nextLine();
            // ask for name
            System.out.print("Enter name: ");
            name = sc.nextLine();
            // ask for balance
            System.out.print("Enter balance: ");
            balance = sc.nextInt();
            // ask to enter another (Y / N)
            System.out.print("Enter another (Y/N): ");
            answer = sc.nextLine();

            accounts[accountCounter] = new Account(accountID, name, balance);
            accountCounter++;

        } while (answer.equalsIgnoreCase("Y"));

        /***
         * CODE for part c) goes here *** print details for all accounts
         * System.out.println("Account Details");
         */


        /***
         * Code for part b) goes here
         ***/

        // Test for myself
          
    }
}