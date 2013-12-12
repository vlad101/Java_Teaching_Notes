class Student
{
	private String name;

	public Student(String n)
	{
		name = n;
	} 
	public Student copy(){
		Student sveta = new Student(name);
		return sveta;
	}
	public String toString(){
		return ("name is "  + name);
	}
}
public class COpyObject 
{
	public static void main(String[] args) 
	{	
		Student vlad = new Student("Vlad");
		System.out.println(vlad.toString());
		Student sveta = vlad.copy(); // copied! success!
		System.out.println(sveta.toString());
		if(!(vlad == sveta))
			System.out.println("Copied! Success!"); // Copied! Success!
	}
}
