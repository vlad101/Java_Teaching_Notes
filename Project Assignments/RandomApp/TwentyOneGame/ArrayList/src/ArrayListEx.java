import java.util.ArrayList;

class Student{
	private int balance;
	public Student(int b){ balance = b;}
	
	public void print()
	{
		System.out.printf("Hello world I have %d\n", balance);
	}
	
}
public class ArrayListEx
{	
	public static void main(String[] args) 
	{	
		ArrayList<Student> name = new ArrayList<Student>();
		
		Student vlad = new Student(100);
		Student sveta = new Student(500);
		
		name.add(vlad);
		name.add(sveta);
		
		for(int i = 0; i < name.size(); i++)
			(name.get(i)).print();
	}
}