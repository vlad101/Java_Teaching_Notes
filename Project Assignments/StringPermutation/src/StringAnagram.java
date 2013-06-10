/**
 * The Recursive String Anagram Program.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the String Permutation [Anagram].
 */

import java.util.Scanner;

public class StringAnagram
{
    public static void main(String[] args)
    {
        // Get the String from the user
        String s = getString();
        
        // Display all the permuttion of the string
        doAnagram("", s);
        System.out.println();
    }
    
    /**
     * The getString method returns the string entered by the user.
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
        
    /**
     * The doAnagram method displays all string permutations
     * @param prefix The beginning of the string
     * @param word The string to be permuted.
     */
    public static void doAnagram(String prefix, String word)
    {
        if(word.length() <= 1)
            System.out.print(prefix + word + " ");
        else
        {
            for(int i = 0; i < word.length(); i++)
            {
                String current = word.substring(i, i + 1);
                String before = word.substring(0, i);
                String after = word.substring(i + 1);
                doAnagram(prefix + current, before + after);
            }
        }
    }
}