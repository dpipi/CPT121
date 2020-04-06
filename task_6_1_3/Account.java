package task_6_1_3;

public class Account {
    private String name;
    protected double balance;
    private String accID;

    // constructor
    public Account(String accID, String name, double amount) {
        this.accID = accID;
        this.name = name;
        this.balance = amount;
    }

    // accessors
    public double getBalance() {
        return balance;
    }

    public String getID() {
        return accID;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {

        System.out.println("AccountID: " + this.accID);
        System.out.println("Name: " + this.name);
        System.out.println("Balance: " + this.balance);
        System.out.println();
    }

    // mutator (setters) – only needed for the name!
    public void setName(String name) {
        this.name = name;
    }

    // operations of the class which define things an
    // Account can actually do
    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        boolean result = false;
        if (balance >= amount) {
            balance = balance - amount;
            result = true;
        }
        return result;
    }

    public boolean transfer(Account account, double amount) {
        // the first step in a transfer is to withdraw the
        // funds from the ‘source’ account
        boolean result = this.withdraw(amount);
        // now check to see if the withdrawal succeeded
        if (result == true) {
            // if the withdrawal worked then deposit funds to
            // ‘destination’ account and return true to
            // indicate success
            account.deposit(amount);
            return true;
        } else {
            // otherwise return false to indicate failure
            return false;
        }

    }

} // end of class
