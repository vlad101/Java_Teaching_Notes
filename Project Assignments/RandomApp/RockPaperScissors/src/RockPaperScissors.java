import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors 
{
	
	public static int count = 0, lost = 0, won = 0; // game counter
	
	public static void main(String[] args)
	{
		do{
			displayMenu();
			int choice = validateInput("Make a Choice: ");
			String userOption = "";
			
			if(choice == 1)
				userOption = "rock";
			else if(choice == 2)
				userOption = "scissors";
			else if(choice == 3)
				userOption = "paper";
			else if(choice == 4)
			{
				System.out.printf("You played %d games. Won: %d games, Lost: %d games\n", count, won, lost);
				System.out.println("Thank you for playing! Bye-bye!");
				break;
			}
			else
				System.out.println("Make a valid choice!");
			String compOption = generate();  // computers option
			
			int results = gameResult(userOption, compOption);
			resultScore(results);
		}
		while(true);
	}
	
	public static int gameResult(String userChoice, String compChoice)
	{
		System.out.println("Your choice was " + userChoice);
		System.out.println("Computer's choice was " + compChoice);
		
		if(userChoice == "rock" && compChoice == "scissors")
		{
			System.out.println("You won! The rock smashes the scissors!\n");
			return 1;
		}
			
		else if(userChoice == "scissors" && compChoice == "rock")
		{
			System.out.println("You lost! The scissors got smashed by the rock!\n");
			return 0;
		}
			
		else if(userChoice == "scissors" && compChoice == "paper")
		{
			System.out.println("You won! The scissors cuts the paper!\n");
			return 1;
		}
		
		else if(userChoice == "paper" && compChoice == "scissors")
		{
			System.out.println("You lost! The paper was cut by the scissors!\n");
			return 0;
		}
		
		else if(userChoice == "paper" && compChoice == "rock")
		{
			System.out.println("You won! The paper wraps the rock!\n");
			return 1;
		}
			
		
		else if(userChoice == "rock" && compChoice == "paper")
		{
			System.out.println("You lost! The rock was wrapped by the paper!\n");
			return 0;
		}
		
		else
			return -1;
	}
	
	public static String generate() // generate computer option
	{
		Random random = new Random();
		String[] choice = {"rock", "scissors", "paper"};
		return choice[random.nextInt(3)];
	}
	
	public static void displayMenu() // display game menu
	{
		System.out.println("****Rock, Paper, Scissors Game*****");
		System.out.println("1. Rock");
		System.out.println("2. Scissors");
		System.out.println("3. Paper");
		System.out.println("4. Quit");
	}
	
	public static void resultScore(int outcome) // result computation
	{
		count++;
		if(outcome == 1) // outcome of the game 
			won++;
		else if(outcome == 0)
			lost++;
		else 
			System.out.println("No winner has been determined! Try Again!\n");
		System.out.println();
		
	}
	
	public static int validateInput(String st) // input validation
	{
		Scanner keyboard = new Scanner(System.in);
		int num = 0;
		while(true)
		{
			try
			{
				do
				{
					System.out.print(st);
					num = Integer.parseInt(keyboard.nextLine());
					if(num <= 0 || num > 5)
						System.out.println("Wrong Value! Enter a valid choice!\n");
				}
				while(num <= 0 || num >= 5);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong Value! Enter a valid choice!\n");
				continue;
			}
			return num;
		}
	}	
}
