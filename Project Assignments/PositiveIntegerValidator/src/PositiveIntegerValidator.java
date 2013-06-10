/**
 * The Positive Integer Validator.
 * @author: Vladimir Efros
 * This program demonstrates an Integer Validator that validates the 
 * input entered by the user to be a positive integer only. 
 */

import java.util.Scanner;

public class PositiveIntegerValidator 
{
    public static void main(String[] args)
    {
        System.out.println(integerValidator("Enter a positive Integer: "));
    }
    
    /**
     * The integerValidaor method converts a String entered to the Integer value.
     * @param st The string prompt to enter the String.
     * @return num if the value is a valid positive number or 0.
     */
    public static int integerValidator(String st)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean b = true;
        int num = 0;
        
        do
        {
            try
            {
                do
                {
                    System.out.print(st);
                    b = true;
                    num = Integer.parseInt(keyboard.nextLine());
                    if(num < 0)
                        System.out.println("Wrong Value! Try again!");
                }
                while(num < 0);
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Wrong Value! Try again!");
                b = false;
            }
        }
        while(b == false);
        return num;        
    }
}