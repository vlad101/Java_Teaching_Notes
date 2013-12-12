
public class Rectangle 
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
	
	public String toString()
	{
		String st = "The length of rectangle is " + getLength() + 
		            ", the width of rectangle is " + getWidth() + 
		            ". The area of rectangle is " + getArea() + ".";
		return st;
	}
	
	public static void main(String[] args) 
	{
		double length = 5;
		double width = 5;
		Rectangle rect1 = new Rectangle(length, width);
		rectInfo(rect1);
		calcArea(rect1);
	}
	
	public static void calcArea(Rectangle r)
	{
		System.out.printf("The area of the rectangle is %.2f\n", r.getArea());
	}
	
	public static void rectInfo(Rectangle r)
	{
		System.out.println(r.toString());
	}
}
