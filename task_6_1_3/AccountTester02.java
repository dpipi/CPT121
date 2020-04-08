package task_6_1_3;

public class AccountTester02
{

    public static void main(String args[])
    {
        // TEST WITHDRAW FROM SAVINGS AND OVERDRAW FACILITY
        ChequeAccount Ac01 = new ChequeAccount("Ac01", "David", 500, 1000);
        ChequeAccount Ac02 = new ChequeAccount("Ac01", "David", 500);
        // String accID, String name, double amount, double overdraftLimit

        /***
         * Testing account 1 withdraw and overdraft facility
         */
        System.out.println("Display balance and overdraft accounts 1");
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 OverDraft Limit = $" + Ac01.getOverdraftLimit());
        System.out.println("Display balance and overdraft accounts 2");
        System.out.println("Ac02 Balance = $" + Ac02.getBalance());
        System.out.println("Ac02 OverDraft Limit = $" + Ac02.getOverdraftLimit());
        System.out.println();
        // withdraw $500 from both accounts
        Ac01.overdraftLimit(5000);
        System.out.println("Withdraw $500 from account 1");
        Ac01.withdraw(500);
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        System.out.println("Withdraw $500 from account 2");
        Ac02.withdraw(500);
        System.out.println("Ac02 Balance = $" + Ac02.getBalance());
        System.out.println("Ac02 amount overdrawn = $" + Ac02.getAmountOverdrawn());
        System.out.println();
        // test overdraw facility by withdrawing another $500
        System.out.println("Withdraw $1000 from account 1");
        Ac01.withdraw(1000);
        System.out.println("Ac01 Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        System.out.println("Withdraw $500 from account 2");
        Ac02.withdraw(500); // should throw error
        System.out.println();
        // test overdraw facility by withdrawing another $500
        System.out.println("Withdraw $500 accounts 1");
        Ac01.withdraw(500); // should raise Insufficient funds message
        System.out.println("Balance = $" + Ac01.getBalance());
        System.out.println("Ac01 amount overdrawn = $" + Ac01.getAmountOverdrawn());
        System.out.println();

        /***
         * TEST DEPOSIT TO ADD FUNDS TO OVERDRAFT AND THEN SAVINGS
         */

    }

}