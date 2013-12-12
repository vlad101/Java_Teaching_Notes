/**
 * The Delimeter Validator.
 * @author: Vladimir Efros
 * This program demonstrates a Delimeter Validator 
 * that checks matching parenthesis.
 */

import java.util.Scanner;

public class DelimeterValidator 
{
    public static void main(String[] args)
    {
        String st = validateStr();
        if(delimeterValidator(st))
            System.out.println("Parenthesis match!");
        else
            System.out.println("Parenthesis do not match!");
    }    
    
    /**
     * The delimeterValidator validates if parenthesis match.
     * @param str The string that contains parenthesis that are to be validated.
     * @return true of parenthesis match, otherwise false if parenthesis do not match.
     */
    public static boolean delimeterValidator(String str)
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) == '(')
                count++;
            else if(str.charAt(i) == ')')
                count--;
        if(count == 0)
            return true;
        else
            return false;
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