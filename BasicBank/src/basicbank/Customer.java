package basicbank;

/**
 *
 * @author Jayuk
 */
public class Customer 
{
    protected String customerName;
    protected int accountNumber;
    protected String address;
    protected int phoneNumber;
    public Account account;
    
    public void customer(String customerName,int accountNumber, String address,int phoneNumber)
    {
        this.customerName=customerName;
        this.accountNumber=accountNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public void createAccount(int accountNumber)
    {
        account = new Account();
       
    }
    public void withdraw(int money)
    {
        account.Balance = account.Balance - money;
        System.out.println("withdraw = "+ money);
        System.out.println("Balance = " + account.Balance);
    }
    public void deposit()
    {
        
    }
}
