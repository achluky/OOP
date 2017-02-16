package basicbank;

/**
 *
 * @author Jayuk
 */
public class Account 
{
    protected int accountNumber;
    protected int Balance;
    protected String custumerName;
    
    public void Account(int accountNumber, int Balance, String customerName)
    {
        this.accountNumber = accountNumber;
        this.Balance = Balance;
        this.custumerName = customerName;
    }
    public void UpdateAccount(int Balance)
    {
        this.Balance = Balance;
    }
}
