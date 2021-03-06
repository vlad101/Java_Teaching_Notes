import java.util.ArrayList;
import java.util.Scanner;

class Person
{
	private String name;
	private String phone;
	
	public Person(String n, String p)
	{
		name = n;
		phone = p;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhone()
	{
		return phone;
	}
}

public class PhoneBookApp {
	
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<Person>();
		
		int peopleNum = validateInput("How many people would you like to add? ");
		
		for(int i = 0; i < peopleNum; i++)
		{
			System.out.println("\nEnter the information for person #" + (i + 1));
			System.out.print("Enter the person's name: ");
			String name = keyboard.nextLine();
			System.out.print("Enter the person's phone number: ");
			String phone = keyboard.nextLine();
			persons.add(new Person(name, phone));
		}
		
		for(int i = 0; i < peopleNum; i++)
		{
			System.out.println("\nThe name of the person #" + (i + 1) + " is " + persons.get(i).getName());
			System.out.println("The phone number of the person #" + (i + 1) + " is " + persons.get(i).getPhone());
		}
	}
	
	public static int validateInput(String st)
	{
		int num = 0;
		
		while(true)
		{
			try
			{
				do
				{
					System.out.print(st);
					num = Integer.parseInt(keyboard.nextLine());
					if(num <= 0)
						System.out.println("Wrong Value! Try Again");
				}
				while(num <= 0);	
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong Value! Try Again");
				continue;
			}
			return num;
		}
	}
}
