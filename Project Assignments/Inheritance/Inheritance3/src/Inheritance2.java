import java.util.Scanner;

class Rectangle
{
	private double length;
	private double width;
	
	public Rectangle(double l, double w)
	{
		length = l;
		width = w;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getArea()
	{
		return length * width;
	}
}

class Cube extends Rectangle
{
	private double heigth;
	
	public Cube(double l, double w, double h)
	{
		super(l, w);
		heigth = h;
	}
	
	public double getHeigth()
	{
		return heigth;
	}
	
	public double getSurfaceArea()
	{
		return getArea() * 6;
	}
	
	public double getVolume()
	{
		return getArea() * heigth;
	}
}

public class Inheritance2 
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		double length = validateInput("Enter the length of the coube: ");
		double width = validateInput("Enter the width of the coube: ");  
		double heigth = validateInput("Enter the heigth of the coube: ");  
		Cube cube = new Cube(length, width, heigth);
		System.out.println("The Length of Cube: " + cube.getLength());
		System.out.println("The Width of Cube: " + cube.getWidth());
		System.out.println("The Heigth of Cube: " + cube.getHeigth());
		System.out.println("The Area of Cube: " + cube.getArea());
		System.out.println("The Surface Area of Cube: " + cube.getSurfaceArea());
		System.out.println("The Volume of the Cube: " + cube.getVolume());
	}
	
	public static double validateInput(String st)
	{
		double num = 0;
		while(true)
		{
			try
			{
				do
				{
					System.out.print(st);
					num = Integer.parseInt(keyboard.nextLine());
					if(num < 0)
						System.out.println("Wrong value! Try again!");
				}
				while(num < 0);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong value! Try again!");
				continue;
			}
			return num;
		}
	}
}
















