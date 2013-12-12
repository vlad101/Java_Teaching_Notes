class ParkedCar
{
	private String make;
	private String model;
	private String color;
	private String licenceNum;
	private int minutes;
	
	public ParkedCar(String m1, String m2, String c, String l, int m3)
	{
		make = m1;
		model = m2;
		color = c;
		licenceNum = l;
		minutes = m3;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	
	public String getColor()
	{
		return color;
	}
	
	public String getlicenceNum()
	{
		return licenceNum;
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public ParkedCar(ParkedCar ParkedCar2)
	{
		make = ParkedCar2.make;
		model = ParkedCar2.model;
		color = ParkedCar2.color;
		licenceNum = ParkedCar2.licenceNum;
		minutes = ParkedCar2.minutes;
	}
	
	public void setParkedCar(String m1, String m2, String c, String l, int m3)
	{
		make = m1;
		model = m2;
		color = c;
		licenceNum = l;
		minutes = m3;
	}
	
	public String toString()
	{
		String st = "The car’s make: " + make + 
					"\nThe car’s model: " + model +
					"\nThe car’s color: " + color +
					"\nThe car’s license number: " + licenceNum +
					"\nThe car’s number of minutes that the car has been parked: " + minutes;
		return st;
	}
}

class ParkingMeter
{
	private int minPurchased;
	
	public ParkingMeter(int min)
	{
		minPurchased = min;
		
	}
	
	public int getMinutesPurchased()
	{
		return minPurchased;
	}
	
	public String toString()
	{
		String st = "The number of minutes of parking time that has been purchased is " + minPurchased;
		return st;
	}
}

class ParkingTicket
{
	private ParkedCar parkedCar;
	private String make;
	private String model;
	private String color;
	private String licenceNum;
	
	private PoliceOfficer officer;
	private String name;
	private String badgeNum;
	
	public ParkingTicket()
	{
		make = parkedCar.getMake();
		model = parkedCar.getModel();
		color = parkedCar.getColor();
		licenceNum = parkedCar.getlicenceNum();
		
		name = officer.getName();
		badgeNum = officer.getBadgeNum();
	}
	
	
}

class PoliceOfficer
{
	private String name;
	private String badgeNum;
	
	public PoliceOfficer(String n, String b)
	{
		name = n;
		badgeNum = b;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getBadgeNum()
	{
		return badgeNum;
	}
	
	public String toString()
	{
		String st = "Police Officer's name is " + name + 
					"\nPolice Officer's badge Number is " + badgeNum;
		return st;
	}
}

public class TicketSimulatorApp {

	public static void main(String[] args) {
		
	}

}
