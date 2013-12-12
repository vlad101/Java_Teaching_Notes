import java.util.Scanner;

class FinalExam extends Grade
{
	private int numQuestions;
	private double pointsEach;
	private int missedQuestions;
	
	public FinalExam(int q, int m)
	{
		numQuestions = q;
		missedQuestions = m;
		pointsEach = 100 / numQuestions;
		double score = 100 - missedQuestions * pointsEach;
		setScore(score);
	}
	
	public double getPointsEach()
	{
		return pointsEach;
	}
	
	public int getNumberMissed()
	{
		return missedQuestions;
	}
	
}

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

public class Inheritance1 
{
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		int questionNum = validateInput("How many questions were on exam? ");
		int questionMissed = validateInput("How many questions missed? ");
		FinalExam finalGrade = new FinalExam(questionNum, questionMissed);
		
		System.out.println("You missed " + finalGrade.getNumberMissed() + " questions! Each question is " + finalGrade.getPointsEach() + " point worth!");
		System.out.println("You got " + finalGrade.getScore() + " points! Your letter grade is " + finalGrade.getGrade() + "!");
	}

	public static int validateInput(String s)
	{
		int n = 0;
		while(true){
			try
			{
				do{
					System.out.print(s);
					n = Integer.parseInt(keyboard.nextLine());
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