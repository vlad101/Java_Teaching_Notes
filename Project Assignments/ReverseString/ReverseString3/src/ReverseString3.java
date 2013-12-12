/**
 * StringBuilder Reverse String.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the String Permutation [Anagram].
 */

import java.util.Scanner;

public class ReverseString3
{
    public static void main(String[] args)
    {
        // Get the string from the user
        String str = getString();
        
        // Reverse the string
        String revStr = revStr(str);
        
        //Display reversed string
        displayStr(str, revStr);
    }
    
    /**
     * The displayStr method display both the original and the reversed string.
     * @param orig The original string before reverse.
     * @param rev  The string after after reverse.
     */
    public static void displayStr(String orig, String rev)
    {
        System.out.println("The original String: " + orig);
        System.out.println("The reversed String: " + rev);
    }
    
    /**
     * The revStr method reverses a string by using StringBuilder.
     * @param s The string that is to be reversed
     * @return The reversed string.
     */
    public static String revStr(String s)
    {
        StringBuilder builder = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--)
            builder.append(s.charAt(i));
        return builder.toString();
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