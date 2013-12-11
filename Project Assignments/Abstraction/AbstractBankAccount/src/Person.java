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
