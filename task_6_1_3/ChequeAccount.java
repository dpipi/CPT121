package task_6_1_3;

import sun.reflect.generics.tree.Tree;
import task_6_1_3.Account;

public class ChequeAccount extends Account
{

    // instant variables
    private double amountOverdrawn;
    private double overdraftLimit;
    private int transactionCount;

    // Check account without overdraft facility
    public ChequeAccount(String accID, String name, double amount)
    {
        super(accID, name, amount);

        amountOverdrawn = 0;
        transactionCount = 0;
        overdraftLimit = 0;

    }

    // Check account with overdraft facility
    public ChequeAccount(String accID, String name, double amount,
                         double overdraftLimit)
    {
        super(accID, name, amount);
        this.overdraftLimit = overdraftLimit;

        amountOverdrawn = 0;
        transactionCount = 0;

    }

    // setters (mutator)
    public void overdraftLimit(double overdraftLimit)
    {

        this.overdraftLimit = overdraftLimit;

    }

    // withdraw method
    public boolean withdraw(double amount)
    {
        // if the withdrawal amount is greater than the total funds available
        // ....Reject transaction
        if (amount > getAvailableFunds())
        {
            // ....funds reject
            System.out.println("Insufficient Funds!");
            return false;
        }
        // else if the current balance == 0
        // ....Add withdrawal amount to amount overdrawn
        else if (super.getBalance() == 0)
        {
            // ....add amount to be overdrawn
            if (amount > getOverdraftLimit() - getAmountOverdrawn())
            {
                System.out.println("Insufficient Funds!");
                return false;
            }
            else
            {
                amountOverdrawn = amountOverdrawn + amount;
                return true;
            }

        }
        else
        // else
        // ....subtract current balance from the withdrawal amount
        // ....withdraw the entire current balance
        // ....add the remaining withdrawal amount to the amount overdrawn
        // ....Increment the transaction count by 1
        {
            // ....subtract current balance from withdraw amount
            super.withdraw(amount);
            // ....Increment the transaction count by one
            transactionCount++;
            return true;

        }
    }

    // getters (accessors)
    public double getAmountOverdrawn()
    {
        return this.amountOverdrawn;
    }

    public double getOverdraftLimit()
    {
        return this.overdraftLimit;
    }

    public int getTransactionCount()
    {
        return this.transactionCount;
    }

    public double getAvailableFunds()
    {
        double totalFundsAvailable =
                    super.getBalance() + (overdraftLimit - getAmountOverdrawn());
        return totalFundsAvailable;
    }

    /***
     * c) The deposit method should be overridden to incorporate the new overdraft
     * ...facility into the deposit
     */
    public void deposit(double amount)
    {
        // if overdraft amount == 0
        // ....Add deposit amount to current balance
        if (amountOverdrawn == 0)
        {
            super.deposit(amount);
        }
        // else if the deposit amount is less than or equal to the amount overdrawn
        // ....subtract deposit amount from amount overdrawn
        else if (amount <= amountOverdrawn)
        {
            amountOverdrawn = amountOverdrawn - amount;
        }
        // else
        // ....subtract amount overdrawn from deposit amount
        // ....add remaining deposit amount to current balance
        else
        {

        }
    }

}