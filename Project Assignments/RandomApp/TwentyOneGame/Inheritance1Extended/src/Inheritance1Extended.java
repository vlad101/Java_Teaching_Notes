import java.util.Scanner;

class Grade
{
	private double score;
	
	public void setScore(double s)
	{
		score = s;
	}
	
	public double getScore()
	{
		return score;
	}
	
	public char getGrade()
	{
		char grade = ' ';
		if(score > 89)
			grade = 'A';
		else if(score > 79 && score <= 89)
			grade = 'B';
		else if(score > 69 && score <= 79)
			grade = 'C';
		else if(score > 65 && score <= 69)
			grade = 'F';
		else
			grade = 'F';
		return grade;	
	}
}

class CurvedGrade extends Grade
{
	private double rawScore;
  	private double percentage;
  	
  	public CurvedGrade(double p)
  	{
  		percentage = p;
  		rawScore = 0.0;
  	}
	
  	public void setScore(double s)
 	{
 		rawScore = s;
 		super.setScore(rawScore + rawScore * percentage / 100);
 	}
  	
  	public double getRawScore()
  	{
  		return rawScore;
  	}
  	
  	public double getPercentage()
  	{
  		return percentage;
  	}
}

public class Inheritance1Extended
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		
		double percent = validateInput("Enter a percent of the curve: ");
		CurvedGrade curvedGrade = new CurvedGrade(percent);
		curvedGrade.setScore(validateInput("Enter your score: "));
		System.out.println("The original score: " + curvedGrade.getRawScore());
		System.out.println("The curve of " + curvedGrade.getPercentage() + " is applied!");
		System.out.println("The adjusted score: " + curvedGrade.getScore());
		System.out.println("The letter grade: " + curvedGrade.getGrade());
	}
	

	public static double validateInput(String s)
	{
		double n = 0;
		while(true){
			try
			{
				do{
					System.out.print(s);
					n = Double.parseDouble(keyboard.nextLine());
					if(n < 0)
						System.out.println("Wrong Value! Try Again!");
				}
				while(n < 0);
			}
			catch(NumberFormatException nfe)
			{
					System.out.println("Wrong Value! Try Again!");
					continue;
			}
			return n;
		}
	}
}