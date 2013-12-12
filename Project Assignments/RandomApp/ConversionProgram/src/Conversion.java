import java.util.Scanner;
import java.util.Random;
public class Conversion{
	
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){
		
		double choice;
		do
		{
			displayMenu();
			choice = checkInput("Enter your choice: ");
			if(choice == 1)
				metersToKilometers();
			else if(choice == 2)
				metersToInches();
			else if(choice == 3)
				metersToFeet();
			else if(choice == 4)
				break;
			else
				System.out.println("Wrong Value! Try again!\n");
		}while(true);
		System.out.println("The program is shutting down! Bye-bye!");
	}
	
	public static void displayMenu()
	{
		System.out.println("********Conversion Menu*********");
		System.out.println("1. Convert meters to kilometers");
		System.out.println("2. Convert meters to inches");
		System.out.println("3. Convert meters to feet");
		System.out.println("4. Quit the program");
		System.out.println("********************************");
	}
	
	public static void metersToKilometers()
	{
		System.out.println("\nConvert Meters to Kilometers!");
		double meters = checkInput("Enter the number of meters: ");
		System.out.printf("%.2f meters = %.2f kilometers\n\n", meters, meters / 1000);
		System.out.println();
	}
	
	public static void metersToInches()
	{
		System.out.println("\nConvert Meters to Inches! ");
		double meters = checkInput("Enter the number of meters: ");
		System.out.printf("%.2f meters = %.2f inches\n\n", meters, meters / 0.0254);
		System.out.println();
	}
	
	public static void metersToFeet()
	{
		System.out.println("\nConvert Meters to Feet! ");
		double meters = checkInput("Enter the number of meters: ");
		System.out.printf("%.2f meters = %.2f feet\n\n", meters, meters * 3.2808);
	}

	public static double checkInput(String st)
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
						System.out.println("The value cannot be negative");
				}
				while(num < 0);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong Value! Try Again!");
				continue;
			}
			return num;
		}
	}
}
