
public class PrintArrayApp 
{

	public static void main(String[] args) 
	{
		String st = "String";
		printString(st, 0);
	}
	
	public static void printString(String s, int minSize)
	{
		if(minSize == s.length() - 1)
		{
			System.out.println(s.charAt(minSize));
			return;
		}
		else
		{
			System.out.print(s.charAt(minSize));
			printString(s, minSize + 1);
		}
	}
}
