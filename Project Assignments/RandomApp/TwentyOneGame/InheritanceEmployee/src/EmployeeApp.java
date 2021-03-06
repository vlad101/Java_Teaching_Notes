class Employee
{
	private String name;
	private String idNum;
	private String hireDate;
	
	public Employee(String n, String id, String h)
	{
		name = n;
		idNum = id;
		hireDate = h;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getIdNum()
	{
		return idNum;
	}
	
	public String getHireDate()
	{
		return hireDate;
	}
}

class ProductionWorker extends Employee
{
	private int shift;
	private double payRate;
	
	public ProductionWorker(String n, String i, String h, int s, double r)
	{
		super(n, i, h);
		shift = s;
		payRate = r;
	}
	
	public int getShift()
	{
		return shift;
	}
	
	public double getPayRate()
	{
		return payRate;
	}
}

class ShiftSupervisor extends Employee
{
	private double salary;
	private double bonus;
	
	public ShiftSupervisor(String n, String i, String h, double s, double b)
	{
		super(n ,i, h);
		bonus = b;
		salary = s;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public double getBonus()
	{
		return bonus;
	}
}

public class EmployeeApp 
{
	public static void main(String[] args) 
	{
        System.out.println("Production Worker");
		ProductionWorker worker = new ProductionWorker("Vlad Efros", "XYZ-L", "11/26/11", 1, 25.0);
		System.out.println("Name: " + worker.getName());
		System.out.println("ID number: " + worker.getIdNum());
		System.out.println("Hire Date: " + worker.getHireDate());
		System.out.println("Shift: " + worker.getShift());
		System.out.println("Pay Rate: " + worker.getPayRate());
		
		System.out.println();
		
		System.out.println("Shift Supervisor");
		ShiftSupervisor supervisor = new ShiftSupervisor("Sveta Efros", "WVK-M", "4/16/10", 35.0, 10.0);
		System.out.println("Name: " + supervisor.getName());
		System.out.println("ID number: " + supervisor.getIdNum());
		System.out.println("Hire Date: " + supervisor.getHireDate());
		System.out.println("Shift: " + supervisor.getSalary());
		System.out.println("Pay Rate: " + supervisor.getBonus());
	}

}
