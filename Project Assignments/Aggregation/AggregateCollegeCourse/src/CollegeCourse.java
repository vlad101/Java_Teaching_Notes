class Instructor
{
	private String name;
	
	public Instructor(String n)
	{
		name = n;
	}
	
	public Instructor(Instructor instr)
	{
		name = instr.name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		String st = "Instructor's name is " + name;
		return st;
	}
}

class Course
{
	private String course;
	private Instructor inst;
	
	public Course(String c, Instructor i)
	{
		course = c;
		inst = new Instructor(i);
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public Instructor getInstructor()
	{
		return new Instructor(inst);
	}
	
	public String toString()
	{
		String st = "The course: "+ course + "\nInstructor's information: \n" + inst;
		return st;
	}
}

public class CollegeCourse {

	public static void main(String[] args) {
		
		Instructor myInstructor = new Instructor("Vladimir Efros");
		Course myCourse = new Course("CIS", myInstructor);
		System.out.println(myCourse);
		
	}

}
