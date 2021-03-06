import java.util.Scanner;

class DriverExam
{
	private char[] answerKey = {'b','d','a','a','c'};
	private String[] studentAnswers;
	
	public DriverExam(String[] s)
	{
		studentAnswers = s;
	}
	
	public void displayStudentAnswers()
	{
		for(int i = 0; i < studentAnswers.length; i++)
			System.out.print(studentAnswers[i].toLowerCase().charAt(0) + " ");
		System.out.println();
	}
	
	public boolean passed()
	{
		int count = 0;
		for(int i = 0; i < studentAnswers.length; i++)
			if((studentAnswers[i].toLowerCase().charAt(0)) == answerKey[i])
				count++;
		if(count >= 3)
			return true;
		return false;
	}
	
	public int totalCorrect()
	{
		int count = 0;
		for(int i = 0; i < studentAnswers.length; i++)
			if((studentAnswers[i].toLowerCase().charAt(0)) == answerKey[i])
				count++;
		return count;
	}
	
	public int totalIncorrect()
	{
		int count = 0;
		for(int i = 0; i < studentAnswers.length; i++)
			if((studentAnswers[i].toLowerCase().charAt(0)) == answerKey[i])
				count++;
		return (5 - count);
	}
}

public class DriverExamApp {
	
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		
		String[] testQuestion = new String[5]; // declare test questions
		
		int studentsNum = validateInput("Enter the number of students who took exam: ");
		DriverExam[] exam = new DriverExam[studentsNum];
		
		for(int i = 0; i < studentsNum; i++)   // for each student get scores, create new exam objects, get scores
		{
			System.out.println("\nGet results for student #" + (i + 1));
			for(int j = 0; j < 5; j++)
			{
				System.out.print("Enter Answer # " + (j + 1) + ": ");
				testQuestion[j] = keyboard.nextLine();
			}
			exam[i] = new DriverExam(testQuestion);
			
			System.out.print("\nDisplay the test scores for student " + (i + 1) + ": ");
			exam[i].displayStudentAnswers();
			if(exam[i].passed())
				System.out.print("Congratulations! You Passed! ");
			else
				System.out.print("You Failed! ");
			
			System.out.println("Your total score is " + exam[i].totalCorrect() * 20 + "%!");
			System.out.println("You got " + exam[i].totalCorrect() + " questions right!");
			System.out.println("You got " + exam[i].totalIncorrect() + " questions wrong!");
			// System.out.println("You missed " + questionsMissed() + " questions!");
		}   
		
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
						System.out.println("Wrong Value! Try Again");
				}
				while(num <= 0);	
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong Value! Try Again");
				continue;
			}
			return num;
		}
	}
}
