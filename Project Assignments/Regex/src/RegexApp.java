import java.util.regex.*;

public class RegexApp 
{
	public static void main(String[] args) 
	{
		String longString = " -5 -0 dsafadasbn ****** NY AC AK CA 11230  me@gmail.com";
		String strangeString = "12 aaa&*(&*&^%%$$#%$%^^%&^&*&*({}:<?>:";
		
		 
		regexChecker("\\s[A-Za-z]{2,20}", longString); // search 2-20 characters word
		regexChecker("\\s[\\d]{5}", longString); // search for a zip code 5 digits long
		regexChecker("\\sA[KLRZ]|C[AOT]\\s", longString); // 2 characters that start with C or A
		regexChecker("\\*{1,}", longString);// minimum of 4 star symbols
		regexChecker("[A-Za-z0-9_%.-]+@[A-Za-z0-9_%.-]+\\.[A-Za-z]{2,4}", longString); // search for an email
		
	}
	
	public static void regexChecker(String theRegex, String str2Check){
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		
		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0) // string should have a length
				System.out.println(regexMatcher.group().trim()); // get rid of the white spaces
			
			System.out.println("Start index: " + regexMatcher.start());
			System.out.println("End index: " + regexMatcher.end() + "\n");
		}
	}
}
