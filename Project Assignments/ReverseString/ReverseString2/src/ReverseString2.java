/**
 * The RecursiveString Reverse by a void function.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the String Permutation [Anagram].
 */

import java.util.Scanner;

public class ReverseString2
{
    public static void main(String[] args)
    {
        // Get the string from the user
        String str = getString();
         
        // Reverse and display the string
        revStr(str, str.length() - 1, 0);
    }
    
    /**
     * The revStr method reverses a string recursively.
     * @param s 
     * @return The reversed string.
     */
    
    /**
     * The revStr method reverses a string recursively.
     * @param s The string that is to be reversed.
     * @param start The last element of the string.
     * @param end The first element of the string.
     */
    public static void revStr(String s, int start, int end)
    {
        if(start < end)
            System.out.print("\n");
        else 
        {
            System.out.print(s.charAt(start));
            revStr(s, start - 1, end);
        }
    }
    
    /**
     * The getString method validates and returns the string entered by the user.
     * @return The string entered by the user.
     */
    public static String getString()
    {
        String st = "";
        Scanner keyboard = new Scanner(System.in);
        do
        {
            System.out.print("Enter the string: ");
            st = keyboard.next();
            if(st == null || st.length() < 1)
                System.out.println("Wrong String! Try again!");
        }
        while(st == null || st.length() < 1);  
        return st;
    }
}