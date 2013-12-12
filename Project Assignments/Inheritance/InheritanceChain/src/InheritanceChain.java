class Mother
{
	private int age;
	private String name;
	
	public Mother(String n, int a)
	{
		name = n;
		age = a;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String says() 
	{
		String st = "I am Mother!";
		return st;
	}
}

class Son extends Mother
{
	private String address;
	
	public Son(String n, int age, String a)
	{
		super(n, age);
		address = a;
	}
	
	public String says() 
	{
		System.out.println(super.says());
		String st = "I am Son!";
		return st;
	}
	
	public String getAddress()
	{
		return address;
	}
}
public class InheritanceChain
{
	public static void main(String[] args)
	{
		Mother mother = new Mother("Sveta", 49);
		Son son = new Son("Vova", 27, "760 E 10th st.");
		System.out.println("Hello I am Mother!");                 // Hello I am Mother!
		System.out.println("My name is " + mother.getName());     // My name is Sveta
		System.out.println("I am " + mother.getAge());            // I am 49
		System.out.println("I say: " + mother.says());            // I say: I am Mother!
		System.out.println();
		System.out.println("Hello I am Son!");                    // Hello I am Son!
		System.out.println("My name is " + son.getName());        // My name is Vova
		System.out.println("I am " + son.getAge());               // I am 27
		System.out.println("My address is " + son.getAddress());  // My address is 760 E 10th st.
		System.out.println("I say: " + son.says());               // I say: I am Mother! // I am Son
		
	}
}