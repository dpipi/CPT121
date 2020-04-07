package task_6_1_3;

import task_6_1_3.Account;

public class ChequeAccount extends Account {

    // instant variables
    private double amountOverdrawn;
    private double overdraftLimit;
    private int transactionCount;

    // Check account without overdraft facility
    public ChequeAccount(String accID, String name, double amount) {
        super(accID, name, amount);

        amountOverdrawn = 0;
        transactionCount = 0;
        overdraftLimit = 0;

    }

    // Check account with overdraft facility
    public ChequeAccount(String accID, String name, double amount, double overdraftLimit) {
        super(accID, name, amount);

        amountOverdrawn = 0;
        transactionCount = 0;

    }

    // setters (mutator)
    public void overdraftLimit(double overdraftLimit) {

        this.overdraftLimit = overdraftLimit;

    }

    public boolean withdraw(double amount) {
        if (getBalance() >= amount + amount){
            super.withdraw(amount);
        }

        return false; 
    }

    // getters (accessors)
    public double getAmountOverdrawn() {
        return this.amountOverdrawn;
    }

    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }

    public int getTransactionCount() {
        return this.transactionCount;
    }

}