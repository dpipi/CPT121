package task_6_1_3;

public class AccountTester02
{

    public static void main(String args[])
    {
        // TEST WITHDRAW FROM SAVINGS AND OVERDRAW FACILITY
        ChequeAccount Ac01 = new ChequeAccount("Ac01", "David", 500, 1000);
        // String accID, String name, double amount, double overdraftLimit

        /***
         * Testing account 1 withdraw and overdraft facility
         */
        System.out.println("Display balance and overdraft accounts 1");
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 OverDraft Limit = $" + Ac01.getOverdraftLimit());
        System.out.println();
        // withdraw $500 from both accounts
        System.out.println("Withdraw $500 from account 1");
        Ac01.withdraw(500);
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        System.out.println();
        // test overdraw facility by withdrawing another $500
        System.out.println("Withdraw $1000 from account 1");
        Ac01.withdraw(1000);
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        // test overdraw facility by withdrawing another $500
        System.out.println("Withdraw $500 accounts 1");
        Ac01.withdraw(500); // should raise Insufficient funds message
        System.out.println("Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        System.out.println();

        /***
         * TEST DEPOSIT TO ADD FUNDS TO OVERDRAFT AND THEN SAVINGS
         */
        // System.out.println("deposit $500 accounts 1");
        // Ac01.deposit(2000);
        // System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        // System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        // System.out.println();

        // System.out.println("deposit $500 accounts 1");
        // Ac01.deposit(500);
        // System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        // System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        // System.out.println();

        // System.out.println("deposit $500 accounts 1");
        // Ac01.deposit(500);
        // System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        // System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        // System.out.println();

        System.out.println("deposit $2000 accounts 1");
        Ac01.deposit(2000);
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        System.out.println();
    }

}