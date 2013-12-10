import java.lang.StringBuilder;

public class test1
{
    public static void main(String[] args)
    {
    	StringBuilder builder = new StringBuilder();
        String st = "Hello World";
        System.out.println(builder.append(reverseStr(st, st.length() - 1, 0)));
    }
    
    public static String reverseStr(String s, int start, int end)
    {
        if(start < end)
        	return "\n";
        else
        {
        	return Character.toString(s.charAt(start)) + reverseStr(s, start + 1, end);
        }
        	
    }
    
}