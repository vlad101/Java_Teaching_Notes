
// Polymorphism

abstract class Ship
{
	private String name;
	private String yearBuild;
	
	public Ship(String n, String y)
	{
		name = n;
		yearBuild = y;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getYearBuild()
	{
		return yearBuild;
	}
	
	public String toString()
	{
		String st = "The ship name is " + name + "\nThe year the ship was built: " + yearBuild;
		return st;
	}
}

class CruiseShip extends Ship
{	
	private int maxPassenger;
	
	public CruiseShip(String n, String y, int m)
	{
		super(n, y);
		maxPassenger = m;
	}
	
	public int getMaxPassenger()
	{
		return maxPassenger;
	}
	
	public String toString()
	{
		String st = "The ship name is " + getName() + "\nThe maximum number of passenger: " + maxPassenger + " passengers";
		return st;
	}
}

class CargoShip extends Ship
{
	private int cargoCapacity;
	
	public CargoShip(String n, String y, int c)
	{
		super(n, y);
		cargoCapacity = c;
	}
	
	public int getCargoCapacity()
	{
		return cargoCapacity;
	}
	
	public String toString()
	{
		String st = "The ship name is " + getName() + "\nThe maximum cargo capacity: " + cargoCapacity + " tons";
		return st;
	}
}

public class ShipApp 
{
	public static void main(String[] args) 
	{
		
		Ship[] ships = {
						new CruiseShip("Cruise Ship", "February 15, 2011", 5000),
						new CargoShip("Cargo Ship", "September 9, 1985", 10000)
						};
		
		System.out.println("---------------------");
		System.out.println("The Ship Information");
		System.out.println("---------------------");
		
		for(Ship s : ships)
		{
			System.out.println(s.toString());
			System.out.println();
		}		
	}
}
