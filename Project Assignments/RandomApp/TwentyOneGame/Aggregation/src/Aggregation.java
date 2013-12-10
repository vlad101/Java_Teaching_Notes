import java.util.Scanner;

public class Aggregation 
{
	
	
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a character: ");
		String ans = " ";
		while (!keyboard.hasNext("[A-Za-z]+")) {
	        System.out.println("Nope, that's not it!");
			System.out.print("Enter a character: ");
			ans = keyboard.nextLine();
	    }
			char resp = ans.charAt(0);
			if(Character.isDigit(resp))
				System.out.println("Entered a number!");
			if(Character.isLetter(resp))
				System.out.println("Entered a letter!");
			if(Character.isLetterOrDigit(resp))
				System.out.println("Entered a number or a letter!");
			if(Character.isLowerCase(resp))
				System.out.println("Entered a low case letter!");
			if(Character.isUpperCase(resp))
				System.out.println("Entered an upper case letter");
			if(Character.isWhitespace(resp))
				System.out.println("Entered a space character");
		
	}

}
