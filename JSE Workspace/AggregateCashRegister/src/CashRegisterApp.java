import java.text.DecimalFormat;

class RetailItem
{
	private String description;
	private int unitsOnHand;
	private double price;
	
	public RetailItem(String d, int u, double p)
	{
		description = d;
		unitsOnHand = u;
		price = p;
	}
	
	public RetailItem(RetailItem RetailItem2)
	{
		description = RetailItem2.description;
		unitsOnHand = RetailItem2.unitsOnHand;
		price = RetailItem2.price;
	}
	
	public void setItem(String d, int u, double p)
	{
		description = d;
		unitsOnHand = u;
		price = p;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int unitsOnHand()
	{
		return unitsOnHand;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		String st = "\nItem: " + description + "\nUnit price: $" + price;
		return st;
	}
}

class CashRegister
{
	private RetailItem item;
	private int qtyPurchased;
	private double subTotal;
	private double tax;
	private double total;
	private final double TAX = 0.06;
	
	public CashRegister(int q, RetailItem r)
	{
		qtyPurchased = q;
		item = new RetailItem(r);
	}
	
	public double getSubTotal()
	{
		return qtyPurchased * item.getPrice();
	}
	
	public double getTax()
	{
		return TAX * getSubTotal();
	}
	
	public double getTotal()
	{
		return (getSubTotal() + getTax());
	}
	
	public RetailItem getItem()
	{
		return new RetailItem(item);
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#.##");
		String st = "SALES RECEIPT" + item + "\nQuantity: " + qtyPurchased +
					"\nSubTotal: $" + df.format(getSubTotal()) + "\nSales Tax: $" + df.format(getTax()) + "\nTotal: $" + df.format(getTotal());
		return st;
	}
}

public class CashRegisterApp 
{

	public static void main(String[] args) 
	{
		RetailItem item1 = new RetailItem("Levi's Jeans", 2, 29.99);
		CashRegister register = new CashRegister(2, item1);
		System.out.println(register);
	}

}