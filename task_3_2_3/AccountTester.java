package task_3_2_3;

public class AccountTester

{
    public static void main(String args[]) {
        Account mum = new Account("s123", "Mercy", 1000.0);
        Account dad = new Account("g234", "David", 2000.0);

        mum.withdraw(100);
        dad.deposit(150);

        dad.transfer(mum, 500);

        System.out.println("mum bal = " + mum.getBalance());
        System.out.println("dad bal = " + dad.getBalance());
    }
}
