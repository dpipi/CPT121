package task_6_2_3;

class FixedRateSAccount extends Account
{
    private double balance;
    private double intRate;

    public FixedRateSAccount(String accountID, String name, double balance,
                             double intRate)
    {
        super(accountID, name, balance);
        this.intRate = intRate;
    }

    public void addInterest()
    {
        balance = super.getBalance() * intRate / 100.0;
        super.deposit(balance);
    }
}