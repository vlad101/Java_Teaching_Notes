public class FindCharApp 
{
	public static void main(String[] args) 
	{
		String st = "String";
		int start = 0;
		findChar(st, start, 'k');
	}
	
	public static void findChar(String s, int i, char c)
	{
		if(s.charAt(i) == c)
			System.out.println("The char is found");
		else if(i == s.length() - 1)
			System.out.println("The char is not found");
		else
			findChar(s, i + 1, c);
	}
}
