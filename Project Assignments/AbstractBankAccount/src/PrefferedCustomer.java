import java.text.DecimalFormat;

class PrefferedCustomer extends Customer
{
	private double amountOfPurchase;
	private int discountLevel;
	
	public PrefferedCustomer(String n, String a, String t)
	{
		super(n, a, t);
	}
	
	public void setAmountOfPurchase(double a)
	{
		amountOfPurchase = a;
	}
	
	public void setDiscountLevel(int d)
	{
		discountLevel = d;
	}	
	
	public double getAmountOfpurchase()
	{
		return amountOfPurchase;
	}
	
	public int getDiscountLevel()
	{
		return discountLevel;
	}		
	
	public String getPrice()
	{
		DecimalFormat df = new DecimalFormat("#.##");
		double originalPrice = getAmountOfpurchase();
		String st = "";
		
		if(getDiscountLevel() == 1)
		{
			st = "You are preffered customer! You spent $" + df.format(originalPrice) + 
				"! Your discount is 5% of the total purchase!" +
				" Your final price is $" + df.format(originalPrice - originalPrice * 0.05);
		}
		
		if(getDiscountLevel() == 2)
		{
			st = "You are preffered customer! You spent $" + df.format(originalPrice) + 
				"! Your discount is 6% of the total purchase!" +
				" Your final price is $" + df.format(originalPrice - originalPrice * 0.06);
		}		
		
		if(getDiscountLevel() == 3)
		{
			st = "You are preffered customer! You spent $" + df.format(originalPrice) + 
				"! Your discount is 7% of the total purchase!" +
				" Your final price is $" + df.format(originalPrice - originalPrice * 0.07);
		}	
		
		if(getDiscountLevel() == 4)
		{
			st = "You are preffered customer! You spent $" + df.format(originalPrice) + 
				"! Your discount is 7% of the total purchase!" +
				" Your final price is $" + df.format(originalPrice - originalPrice * 0.07);
		}	
		
		return st;
	}
}
