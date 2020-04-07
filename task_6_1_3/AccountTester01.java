package task_6_1_3;

import java.util.*;

public class AccountTester01
{
    public static void main(String args[])
    {
        String accountID;
        String name;
        int accountCounter = 0;
        double balance;

        Scanner sc = new Scanner(System.in);

        /*** Array used to store up to 10 accounts ***/
        Account[] accounts = new Account[10];

        /*** CODE for part a) goes here ***/
        String answer = "Y"; // set variable for do while loop
        do
        {

            // ask for accountID
            System.out.print("Enter accountID: ");
            accountID = sc.nextLine().toUpperCase();
            // ask for name
            System.out.print("Enter name: ");
            name = sc.nextLine();
            // ask for balance
            System.out.print("Enter balance: ");
            balance = sc.nextInt();
            sc.nextLine();
            // ask to enter another (Y / N)
            System.out.print("Enter another (Y/N): ");
            answer = sc.nextLine().toUpperCase();

            // add details to array
            accounts[accountCounter] = new Account(accountID, name, balance);
            accountCounter++;

        } while (answer.equals("Y"));

        // Code for part c)

        /***
         * i) Iterate through the objects currently stored in the array and add 1%
         * ...interest to any account with a balance > $2000
         */

        for (int i = 0; i < accountCounter; i++)
        {
            // test if balance > 2000
            if (accounts[i].getBalance() > 2000)
            {
                accounts[i].deposit(accounts[i].getBalance() * .01);
            }
        }

        /***
         * ii) Prompt user to enter an account ID, locate the Account object with
         * that ID and process a withdrawal (getting the withdrawal amount from the
         * user). If the ID is not found or the withdrawal fails then an appropriate
         * error message should be displayed to the user.If the withdrawal is
         * successful then display the new balance to the user.
         */

        // get account id from user
        System.out.println("Enter withdraw accountID: ");
        String accountDetail = sc.nextLine();
        // iterate through array to see if accountID exists
        for (int i = 0; i < accountCounter; i++)
        {
            // test for account ID in array
            if (accounts[i].getID().equalsIgnoreCase(accountDetail))
            {
                // get withdraw amount from user
                System.out.println("Enter withdraw amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                // get boolean on success or failure of withdraw
                boolean success = accounts[i].withdraw(amount);
                // display message based on withdraw success or failure
                if (success == true)
                {
                    System.out.println("Withdraw successful");
                }
                else
                {
                    System.out.println("Insufficient funds!");
                }
            }
        }

        /***
         * iii) Prompt the user to enter the names of two Account holders to organize
         * a transfer for, locate the Accounts with the specified names and proceed
         * with a transfer from the first account to the second. If either one or
         * both of the accounts are not found, or the attempting transfer of funds
         * fails, then a suitable error message should be displayed to the user. If
         * the transfer is successful then display the new balances for the two
         * Accounts to the user. Note that you should only use the one search loop to
         * locate the to Accounts in question as this is a more efficient approach to
         * the problem.
         */

        // ask user for accountID to withdraw from
        System.out.println("Enter accountID to withdraw from:");
        String accountOne = sc.nextLine();
        int accountOnePos = 0;
        // test if accountID for withdraw exists
        boolean accountOneExists = false;
        for (int i = 0; i < accountCounter; i++)
        {
            if (accounts[i].getID().equalsIgnoreCase(accountOne))
            {
                accountOneExists = true;
                accountOnePos = i;
                break;
            }
            else
            {
                accountOneExists = false;
            }
        }

        // ask user for accountID to deposit into
        System.out.println("Enter accountID to deposit into:");
        String accountTwo = sc.nextLine();
        int accountTwoPos = 0;
        // test if accountID for deposit exists
        boolean accountTwoExists = false;
        for (int i = 0; i < accountCounter; i++)
        {
            if (accounts[i].getID().equalsIgnoreCase(accountTwo))
            {
                accountTwoExists = true;
                accountTwoPos = i;
                break;
            }
            else
            {
                accountTwoExists = false;
            }
        }

        if (accountOneExists == true && accountTwoExists == true)
        {
            System.out.println("Enter amount to transfer");
            double transferAmount = sc.nextDouble();
            boolean transferSuccess = accounts[accountOnePos]
                        .transfer(accounts[accountTwoPos], transferAmount);

            if (transferSuccess == true)
            {
                System.out.println("Transfer of funds successful!");
            }
            else
            {
                System.out.println("Transfer of funds failed!");
            }
        }

        // Code for part b)
        /***
         * print details for all accounts
         */
        System.out.println("Account Details");
        for (int i = 0; i < accountCounter; i++)
        {
            System.out.println("Account ID: " + accounts[i].getID());
            System.out.println("Name: " + accounts[i].getName());
            System.out.println("Balance: " + accounts[i].getBalance());
            System.out.println();
        }

        sc.close();

    }
}