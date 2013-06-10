/**
 * The String Palindrome.
 * @author: Vladimir Efros
 * This program demonstrates a regular palindrome. [Palindrome is a string
 * of numbers or letters that is the same forward as backward.]
 */

import java.util.Scanner;

public class Palindrome 
{
    public static void main(String[] args)
    {
        String st = validateStr();
        if(palindrome(st))
            System.out.println("The String is Palindrome!");
        else
            System.out.println("The String is not Palindrome!");
    }
    
    /**
     * The palindrome method checks if the String is Palindrome
     * @param str
     * @return 
     */
    public static boolean palindrome(String str)
    {
        int i, j;
        int count = 0;
        for(i = 0, j = str.length() - 1; i <= str.length() - 1 && j >= 0; i++, j--)
            if(str.charAt(i) == str.charAt(j))
                count++;
        return count == str.length() ? true : false;
    }
    
    /**
     * The validateStr method validates the String that is entered by the user.
     * @return true if the String entered is valid, otherwise returns false.
     */
    public static String validateStr()
    {
        Scanner keyboard = new Scanner(System.in);
        String str;
        
        do
        {
            System.out.print("Enter a String to validate a palindrome: ");
            str = keyboard.nextLine();
            if(str == null | str.length() < 1)
                System.out.println("Wrong String! Try again!");
        }
        while(str == null | str.length() < 1);
        return str;
    }
}