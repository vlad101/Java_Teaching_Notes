import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;

public class StringFun
{
	public static void main(String[] args) 
	{	
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter any string  to be tokenized and each word to be printed backwards: ");
		String stringInput = keyboard.nextLine(); 
		
		StringTokenizer st = new StringTokenizer(stringInput);  // create a new tokenizer object
		ArrayList<String> str = new ArrayList<String>();        // create a new ArrayList object
		
		System.out.println("Original String: " + stringInput);
		
		System.out.print("Inverted String: ");
		tokenize(st, str);    // tokenize String
		invert(str);          // invert each word
		
		System.out.print("Reversed String: ");
		reverse(stringInput); // reverse String
	}
	
	public static void reverse(String st)
	{
		for(int i = st.length() - 1; i >= 0; i--)
			System.out.print(st.charAt(i));
		System.out.println();
	}
	
	public static void tokenize(StringTokenizer st, ArrayList<String> str){
		while(st.hasMoreTokens())
		{
			str.add(st.nextToken());
			str.add(" ");
		}
	}
	
	public static void invert(ArrayList<String> str)
	{
		int i;
		for(i = 0; i < str.size(); i++)
			for(int j = str.get(i).length() - 1; j >= 0; j--)
				System.out.print(str.get(i).charAt(j));
		System.out.println();
	}
}