/**
 * The Recursive Factorial Series.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the Factorial series.
 */

import java.util.Scanner;

public class Factorial 
{
    public static void main(String[] args)
    {
        // Get the nth term for the Factorial Series.
        int num = getTerm();
        
        //  Display the nth term.
        displayTerm(num);
        
        // Display the first 10 values of the Factorial Series.
        displaySeries();
    }
    
    public static int getTerm()
    {
        return validateInteger("Enter the nth term of the Factorial series: ");
    }
    
    public static void displayTerm(int n)
    {
        System.out.println("The " + n + "! is " + factorial(n));
    }
    
    public static void displaySeries()
    {
        System.out.println("\nThe first 10 terms of the Facrtorial series: ");
        for(int i = 0; i < 10; i++)
            System.out.println(i + "! " + " = " + factorial(i));
    }
        
    /**
     * The factorial method gets the value of the nth term of the Factorial Series.
     * @param n The nth term entered by the user.
     * @return The nth term of the Factorial Series.
     */
    public static int factorial(int n)
    {
        if(n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the nth term of the Factorial Series.
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
                do
                {
                    b = true;
                    System.out.print(str);
                    x = Integer.parseInt(keyboard.next());
                    if(x < 0)
                        System.out.println("Must Enter a Positive number! Try again!");
                }
                while(x < 0);
                System.out.println();
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