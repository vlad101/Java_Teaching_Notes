import java.util.Scanner;
import java.util.Random;

class Player
{
	private String name;
	private int total;
	private int dieValue1, dieValue2;
	
	public Player(String n)
	{
		name = n;
	}
	
	public void rollDieValue()
	{
		Die die1 = new Die();
		Die die2 = new Die();
		setTotalDieValue(die1.rollDice() + die2.rollDice());
	}
	
	public void setTotalDieValue(int t)
	{
		total = t;
	}
	
	public int getTotalDieValue()
	{
		return total;
	}
	
	public String getName()
	{
		return name;
	}
	
}

class Die
{
	
	public int rollDice()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}


public class TwentyOneApp {
	
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		
		System.out.println("*************Twenty-One!*************\n");
		
		int input; // prompts 1 or 2 to continue or to quit
		int playersNum = validateInput("Enter the number of players: ");
		
		Player[] players = new Player[playersNum]; // create player objects
		for(int i = 0; i < playersNum; i++)
		{
			players[i] = setPlayer(i);
		}
		
		for(int i = 0; i < playersNum; i++){
			int total = 0;
			do{
				System.out.println("\nPlayer " + players[i].getName() + " rolls the die!");
				players[i].rollDieValue();
				System.out.println("Die value: " + players[i].getTotalDieValue());
				total += players[i].getTotalDieValue();
				players[i].setTotalDieValue(total);
				System.out.println("Your total amount of points so far is : " + total);
				input = validateInput("Do you want to continue? [1] - continue, [2] - quit! ");
				while(input >3)
					input = validateInput("Wrong Value! Try again! [1] - continue, [2] - quit! ");
			}while(input == 1);
		}
		
		scoreCalculation(players);
	}
	
	public static void scoreCalculation(Player[] players)
	{
		String name = " ";
		int max = 0;
		
		for(int i = 0; i < players.length; i++)
		{	
			System.out.println("\nPlayer " + players[i].getName() + " received " + players[i].getTotalDieValue() + " points");
			
			if(players[i].getTotalDieValue() > 21)
				System.out.println(players[i].getName() + " lost because earned more than 21 points!");
			
			if(players[i].getTotalDieValue() >= max  && players[i].getTotalDieValue() <= 21)
			{
				max = players[i].getTotalDieValue();
				name = players[i].getName();
			}
		}
		if(max <= 21)
			System.out.println("The winner is " + name + " with the score " + max + " points!");
		else
			System.out.println("The winner cannot be determined!");
	}
	
	public static Player setPlayer(int num)
	{
		System.out.printf("Enter Player %d name: ", (num + 1));
		String name = keyboard.nextLine();
		return new Player(name);
	}
		
	public static int validateInput(String st)
	{
		int num = 0;
		while(true)
		{
			try
			{
				do
				{
					System.out.print(st);
					num = Integer.parseInt(keyboard.nextLine());
					if(num <= 0)
						System.out.println("Wrong Value! Try again!");
				}
				while(num <= 0);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong Value! Try again!");
				continue;
			}
			return num;
		}
	}

}
