import java.text.DecimalFormat;

abstract class BankAccount
{
	private double balance;
	private int numDeposits = 0;
	private int numWithdrawal = 0;
	private double interestAnnualRate;
	private double serviceCharge;

	public BankAccount(double b, double i)
	{
		balance = b;
		interestAnnualRate = i;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
		numDeposits++;
	}
	
	public void withdraw(double amount)
	{
		balance -= amount;
		numWithdrawal++;
	}
	
	public void calcInterest()
	{
		balance += balance * interestAnnualRate / 12;
	}
	
	public void monthlyProcess()
	{
		balance = balance - serviceCharge;
		calcInterest();
		numDeposits = 0;
		numWithdrawal = 0;
		serviceCharge = 0;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public int getNumWithdrawal()
	{
		return numWithdrawal;
	}
	
	public double getServiceCharge()
	{
		return serviceCharge;
	}
	
	public void setServiceCharge(double a)
	{
		serviceCharge = a;
	}
}

class SavingsAccount extends BankAccount
{
	private BankAccount bank;
	private boolean accountStatus = false;
	
	public SavingsAccount(double b, double i)
	{
		super(b, i);
	}
	
	public boolean isActive()
	{
		if(getBalance() >= 25)
			accountStatus = true;
		return accountStatus;
	}
	
	public void withdraw(int value)
	{
		if(!(isActive()))
		{
			System.out.println("The account is inactive! No withdrawals can be made until the balance is $25!");
		}
		else
		{
			System.out.println("The account is active!");
			if(getNumWithdrawal() > 4)
				if(value > 4)
					setServiceCharge(getServiceCharge() + 1);
			if(!(isActive()))
				super.withdraw(value);
		}
	}
	
	public void deposit(double value)
	{
		if(!(isActive()))
		{
			if(getBalance() + value >= 25)
			{
				accountStatus = true;
				super.deposit(value);
			}
				
		}
	}
}

public class BankAccountApp 
{

	public static void main(String[] args) 
	{
		SavingsAccount account = new SavingsAccount(500.00, 0.15);
		
	}

}
+