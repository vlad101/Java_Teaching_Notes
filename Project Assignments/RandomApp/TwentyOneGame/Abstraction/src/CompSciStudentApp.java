abstract class Student
{
	private String name;
	private String idNumber;
	private int yearAdmitted;
	
	public Student(String n, String id, int year)
	{
		name = n; 
		idNumber = id;
		yearAdmitted = year;
	}
	
	public String toString()
	{
		String st = "\nName: " + name + "\nID Number: " + idNumber + "\nYear of Admission:  "  + yearAdmitted;
		return st;
	}
	
	public abstract int getRemainingHours();
}

class CompSciStudent extends Student
{
	// Required hours
	private final int MATH_HOURS = 20;
	private final int CS_HOURS = 40;
	private final int GEN_ED_HOURS = 60;
	
	public CompSciStudent(String n, String id, int year)
	{
		super(n, id, year);
	}
	
	// Hourse taken
	private int mathHrs;
	private int csHrs;
	private int genEdHrs;

	public void setMathHrs(int m)
	{
		mathHrs = m;
	}
	
	public void csHrs(int c)
	{
		csHrs = c;
	}
	
	public void setGenEdHrs(int g)
	{
		genEdHrs = g;
	}
	
	public int getRemainingHours()
	{
		return (MATH_HOURS + CS_HOURS + GEN_ED_HOURS) - (mathHrs + csHrs + genEdHrs);
	}
}

public class CompSciStudentApp
{
	public static void main(String[] args) 
	{
		CompSciStudent student = new CompSciStudent("Vlad", "1234D", 1985);
		student.setMathHrs(5);
		student.csHrs(5);
		student.setGenEdHrs(5);
		
		System.out.println("Student Information -> " + student.toString());
		System.out.println("Remaining Hours: " + student.getRemainingHours() + " hours");
	}

}