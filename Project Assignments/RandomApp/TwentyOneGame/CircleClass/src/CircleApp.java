import java.util.Scanner;

class Circle
{
	private double radius;
	
	public Circle(double r)  // constructor
	{
		radius = r;  
	}
	
	public double getRadius() // return the value of the radius
	{
		return radius;
	}
	
	public double getArea() // return the value of the Area
	{
		return radius * radius * Math.PI;
	}
	
	public double getDiameter()  // return the value of the Diameter
	{
		return radius * 2;  
	}
	
	public double getCircumference()  // return the value of the Circumference
	{
		return radius * 2 * Math.PI;
	}

}

public class CircleApp 
{
	
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int num = (int) numberOfCircles(); // enter the number of circles
		
		Circle[] circles = new Circle[num]; // declare an array of circles
		
		for(int i = 0; i < num; i++)// create new circle objects
		{
			circles[i] = createCircle(i);
		}
		
		displayCircle(circles); // display info
			
	}
	
	public static int numberOfCircles()
	{
		int num;
		System.out.println("The program calculates the area, diameter, and circumference of the circle based on the radius entered!");
		
		do
		{
			num = (int) validateInput("How many circles would you like to create: ");
		}
		while(num <= 0);
		return num;
	}
	
	public static void displayCircle(Circle[] circles)
	{
		for(int i = 0; i < circles.length; i++){ // display information for each circle object
			System.out.println("\nThe information for circle "  + (i + 1) + "!");
			System.out.printf("The radius of the circle is %.2f cm\n", circles[i].getRadius());
			System.out.printf("The area of the circle is %.2f cm^2\n", circles[i].getArea());
			System.out.printf("The diameter of the circle is %.2f cm\n", circles[i].getDiameter());
			System.out.printf("The circumference of the circle is %.2f cm\n\n", circles[i].getCircumference());
		}
	}
	
	public static Circle createCircle(int num)
	{
		double radius = validateInput("Enter the radius of circle " + (num + 1) + " (in cm): ");
		return new Circle(radius); // create a new circle object with a given radius
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
					num = Double.parseDouble(keyboard.nextLine());
					if(num < 0)
						System.out.println("Wrong value! Try Again!");
				}
				while(num < 0);
			}
			catch(NumberFormatException NFE)
			{
				System.out.println("Wrong value! Try Again!");
				continue;
			}
			return num;
		}
	}
}
