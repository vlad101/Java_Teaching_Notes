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
