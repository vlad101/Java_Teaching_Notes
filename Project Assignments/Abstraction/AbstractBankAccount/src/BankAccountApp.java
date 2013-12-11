public class BankAccountApp 
{
	public static void main(String[] args) 
	{
		SavingsAccount account = new SavingsAccount(500.00, 0.15);

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
