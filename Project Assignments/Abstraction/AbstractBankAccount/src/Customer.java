class Customer extends Person
{
	private String custNum;
	private boolean mailList;
	
	public Customer(String n, String a, String t)
	{
		super(n, a, t);
	}
	
	public void setCustNum(String cn)
	{
		custNum = cn;
	}
	
	public void setMailList(boolean ml)
	{
		mailList = ml;
	}
	
	public String getMailList()
	{
		String st;
		if(mailList)
			st = "The customer is on the mailing list";
		else
			st = "The customer is not on the mailing list";
		return st;
	}
	
	public String getCustNum()
	{
		return custNum;
	}
}
