/**
 * The Recursive Greatest Common Divisor.
 * @author: Vladimir Efros
 * This program gives a simple demonstration 
 * of the determining the greatest common divisor.
 */

import java.util.Scanner;

public class GCD
{
    public static void main(String[] args)
    {
        // Get the two numbers
        double x = getNum();
        double y = getNum();
        
        // Display the Result calculation
        displayResult(x, y);
    }
    
    /**
     * The displayResult returns the Greatest Common Divisor.
     * @param a The first number entered by the user.
     * @param b The second number entered by the user.
     */
    public static void displayResult(double a, double b)
    {
        System.out.println("The greatest common divisor of " + 
                a + " and " + b + " is " + gcd(a, b));
    }
    
    /**
     * @return The number entered by the user.
     */
    public static double getNum()
    {
        return validateInteger("Enter the number: ");
    }
    
    /**
     * The gcd method calculates the greatest common divisor of the two numbers.
     * @param num1 The first number.
     * @param num2 The second number
     * @return The greatest common divisor of the two numbers.
     */
    public static double gcd(double num1, double num2)
    {
        if(num1 % num2 == 0)
            return num2;
        else
            return gcd(num2, num1 % num2);
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the first and the second number.
     * @return The x in the proper integer format.
     * @exception NumberFormatException when x has a wrong integer format.
     */
    public static int validateInteger(String str)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean b = true;
        int x = 0;
        do
        {
            try 
            {
                b = true;
                System.out.print(str);
                x = Integer.parseInt(keyboard.next());
            }
            catch(NumberFormatException nfe) 
            {
                b = false;
                System.out.println("Must Enter Integer! Try again!");
            }
        }
        while(b == false);
        return x;
    }
}