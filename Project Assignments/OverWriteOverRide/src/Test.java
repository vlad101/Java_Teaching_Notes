class SuperClass
{
	public void showValue(int arg)
	{
		System.out.println("SUPERCLASS: The int arg was " + arg);
	}
	
	public void showValue(String arg)
	{
		System.out.println("SUPERCLASS: The String arg was " + arg);
	}
}

class SubClass extends SuperClass
{
	public void showValue(int arg)
	{
		System.out.println("SUBCLASS: The int arg was " + arg);
	}
	
	public void showValue(Double arg)
	{
		System.out.println("SUBCLASS: The Double arg was " + arg);
	}	
	
	public void showValue(String arg)
	{
		super.showValue(arg); // call the superClass method
		System.out.println("SUBCLASS: The String arg was " + arg);
	}
}

public class Test 
{
	public static void main(String[] args) 
	{
		SubClass myObject = new SubClass();
		myObject.showValue(10); // Overridding: SUBCLASS: The int arg was 10
		myObject.showValue(1.2); // Overloading: SUBCLASS: The Double arg was 
		myObject.showValue("Hello"); // Overloading: SUPERCLASS: The String arg was Hello
		myObject.showValue("Hello"); // SUPERCLASS: The String arg was Hello; // SUBCLASS: The String arg was Hello
	}
}
