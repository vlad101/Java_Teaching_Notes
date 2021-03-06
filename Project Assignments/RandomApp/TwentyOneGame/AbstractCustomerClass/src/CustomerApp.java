import java.text.DecimalFormat;

abstract class Person
{
	private String name;
	private String address;
	private String telephone;
	
	public Person(String n, String a, String t)
	{
		name = n;
		address = a;
		telephone = t;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getTelephone()
	{
		return telephone;
	}
}

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

public class CustomerApp {

	public static void main(String[] args) {
		
		Customer cust1 = new Customer("Vlad", "32 Bleekker St. NY, NY", "12345");
		cust1.setCustNum("213-CUST");
		cust1.setMailList(true);
		
		System.out.println("---------------------");
		System.out.println("Customer Information");
		System.out.println("---------------------");
		System.out.println("Name: " + cust1.getName());
		System.out.println("Adddress: " + cust1.getAddress());
		System.out.println("Telephone number: " + cust1.getTelephone());
		System.out.println("Customer Number: " + cust1.getCustNum());
		System.out.println(cust1.getMailList());
		System.out.println();
		
		PrefferedCustomer cust2 = new PrefferedCustomer("Sveta", "35 Blet St. NY, NY", "67891");
		cust2.setCustNum("215-CUST");
		cust2.setMailList(false);
		cust2.setAmountOfPurchase(100.00);
		cust2.setDiscountLevel(4);
		
		System.out.println("-------------------------------");
		System.out.println("Preffered Customer Information");
		System.out.println("-------------------------------");
		System.out.println("Name: " + cust2.getName());
		System.out.println("Adddress: " + cust2.getAddress());
		System.out.println("Telephone number: " + cust2.getTelephone());
		System.out.println("Customer Number: " + cust2.getCustNum());
		System.out.println(cust2.getMailList());
		System.out.println("Discount Level: " + cust2.getDiscountLevel());
		System.out.printf("The amount of purchase: $%.2f\n", cust2.getAmountOfpurchase());
		System.out.println(cust2.getPrice());
		
		System.out.println();
		
	}
}
