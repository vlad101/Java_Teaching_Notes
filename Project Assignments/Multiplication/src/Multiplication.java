/**
 * The Recursive Multiplication Program.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the multiplication of two numbers.
 */

import java.util.Scanner;

public class Multiplication
{
    public static void main(String[] args)
    {
        // Get two numbers
        double x = getNum();
        double y = getNum();
        
        // Display the calculation result
        displayResult(x, y);
    }
    
    /**
     * The displayResult method displays result of the multiplication of two numbers.
     */
    public static void displayResult(double a, double b)
    {
        System.out.println(a + " * " + b + " = " + mult(a, b));
    }
    
    /**
     * The getNum method returns the number entered by the user.
     * @return The number entered by the user.
     */
    public static double getNum()
    {
        return validateInteger("Enter the number: ");
    }
    
    /**
     * The mult method multiplies two numbers.
     * @param num1 The first number.
     * @param num2 The second number. [positive number only]
     * @return The product of the numbers num1 and num2.
     */
    public static double mult(double num1, double num2)
    {
        if(num2 == 0)
            return 0;
        else
            return num1 + mult(num1, num2 - 1);
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