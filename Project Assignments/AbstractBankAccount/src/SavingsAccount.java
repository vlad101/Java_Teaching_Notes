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
