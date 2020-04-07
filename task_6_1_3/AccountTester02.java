package task_6_1_3;

public class AccountTester02
{

    public static void main(String args[])
    {
        // String accID, String name, double amount
        ChequeAccount CAccount01 = new ChequeAccount("Acc01", "David", 500);
        // String accID, String name, double amount, double overdraftLimit

        CAccount01.displayDetails();
        CAccount01.deposit(500);
        CAccount01.displayDetails();
        CAccount01.withdraw(100);
        CAccount01.displayDetails();

    }

}