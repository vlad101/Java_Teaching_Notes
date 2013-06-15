import java.util.Scanner;

class Student
{
	private String name;
	private int[] grades;
	private int gradesNum;
	
	public Student(String n, int testNum, int[] s)
	{
		grades = s; // array of test scores
		name = n; // name of the student
		gradesNum = testNum; // the number of test taken
	}
	
	public void getName() // display student's name
	{
		System.out.println(name); 
	}
	
	public void getScores() // display student's scores
	{
		System.out.print("List of scores: ");
		for(int i = 0; i < gradesNum; i++)  // for each element in the array
			System.out.print(grades[i] + " "); // display grade
		System.out.println();
	}
	
	public void getAverage() // calculate and display average
	{
		double sum = 0; // initialize accumulator of scores
		for(int i = 0; i < gradesNum; i++) // add all of the grades
			sum += grades[i];
		System.out.printf("Average %.2f \n", sum/gradesNum);
		if(sum/gradesNum > 89 && sum/gradesNum < 200) // if above 90, A
			System.out.println("You got A! ");
		else if(sum/gradesNum > 79 && sum/gradesNum <= 89) // if above 80, B
			System.out.println("You got B! ");
		else if(sum/gradesNum >= 65 && sum/gradesNum <= 79) // if above 70, C
			System.out.println("You got C! ");
		else
			System.out.println("You Failed!"); // if below 65, Failed
	}
	
	public void removeLowestScore() // remove the lowest score of the array
	{
		int low = 210;  // declare the lowest value
		for(int i = 0; i < gradesNum; i++) // for each value
			if(grades[i] < low) // find the value which is lower than the variable low
				low = grades[i]; // if found, assign a new low
		
		if(gradesNum >= 2) // make sure there is more than only one score
		{
			System.out.printf("The lowest grade %d will be excluded from the average!\n", low);
			gradesNum--; // decrement the number of scores
			removeLowestScore(low); // call the remove lowest score function
		}
		else
			System.out.println("No score will be removed! "); // otherwise, no score will be removed
		
		
	}
	
	public void removeLowestScore(int value) // removes the lowest score from the array
	{
		int i;
		for(i = 0; i < gradesNum; i++) // for each score
			if(grades[i] == value) // find the lowest value
				break; // found, break out of the loop
			for(int j = i; j < gradesNum; j++) // for the rest of the scores
				grades[j] = grades[j + 1]; // move higher values down
			getScores(); // display the scores
			getAverage(); // calculate average
	}
}

public class Grader 
{
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{	
		int studNum = setStudNum(); // get the number of students
		Student[] student = new Student[studNum]; // create an array of student objects
		
		for(int i = 0; i < studNum; i++){ // for each student
			String name = setStudName();
			int testNum = setTestNum(); // set a number of test scores, size of the scores array
			int[] scores = new int[testNum]; // create an array containing student scores
			setScores(scores, testNum);  // set grades and add them to an array
			student[i] = new Student(name, testNum, scores); // pass name, scores, amount of grades to the Student Constructor
			System.out.println();
		}
		
		for(Student s : student) // get following information from the student object
		{
			s.getName(); // get Student's name
			s.getScores(); // get Student's scores
			s.getAverage(); // get Student's average
			s.removeLowestScore(); // remove the lowest score
			System.out.println();
		}
	}
		
	public static int setStudNum() // set the number of students in the class
	{
		int num = 0;
		while(true){
			try
			{
				do{
					System.out.print("How many students in the class? ");
					num = Integer.parseInt(keyboard.nextLine());
					if(num <= 0)
						System.out.println("Wrong Value! Try again!");
				}while(num <= 0);
			}
			catch(Exception nfe)
			{
				System.out.println("Wrong Value! Try again!");
				continue;
			}
			return num;
		}
	}
	
	public static String setStudName() // set the name of the student
	{
		System.out.print("Enter student's name: ");
		return keyboard.nextLine();	
	}
	
	public static int setTestNum() // set the number of the taken tests
	{
		int num = 0;
		while(true){
			try
			{
				do{
					System.out.print("How many grades is to be entered? ");
					num = Integer.parseInt(keyboard.nextLine());
					if(num < 0)
						System.out.println("Wrong Value! Try again!");
				}while(num < 0);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Wrong Value! Try again!");
				continue;
			}
			return num;
		}
	}
	
	public static void setScores(int[] scores, int testNum){ // set grades and add them to an array
		for(int j = 0; j < testNum; j++){ // for each test grade
			int num = 0;
			while(true){
				try
				{
					do{
						System.out.print("Grade " + (j + 1)+ ": "); 
						num = Integer.parseInt(keyboard.nextLine());
						if(num < 0)
							System.out.println("Wrong Value! Try again!");
					}while(num < 0);
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Wrong Value! Try again!");
					continue;
				}
				scores[j] = num;
				break;
			}
		}
	}	
}