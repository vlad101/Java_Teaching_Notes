/**
 * The Recursive Fibonacci Series.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the Fibonacci Series.
 */

import java.util.Scanner;

public class FibonacciSeries
{
    public static void main(String[] args)
    {
        // Get the nth term for the Fibonacci Series
        int term = getTerm();
        
        // Display the nth term of the Fibonacci Series.
        displayTerm(term);        
        
        // Display the first 10 values of the series.
        displaySeries();
    }
    
    /**
     * Displays the nth term of the Fibonacci Series.
     * @param num The term entered by the user.
     */
    public static void displayTerm(int num)
    {
        System.out.println("The " + num + 
                            " term of the Fibonacci Series is " + fib(num - 1));
    }
    
    /**
     * @return The number entered by the user.
     */
    public static int getTerm()
    {
        return validateInteger("Enter the term for the Fibonacci series: ");
    }
    
    /**
     * Displays the first 10 terms of the Fibonacci Series.
     */
    public static void displaySeries()
    {
        System.out.println("\nThe first 10 terms of the Fibonacci Series: ");
        for(int i = 0; i < 10; i++)
        {
            if(i == 9)
                System.out.print(fib(i) + "\n");
            else
                System.out.print(fib(i) + ", ");
        }
    }
    
    /**
     * The fib method gets the value of the nth term of the Fibonacci Series.
     * @param n The nth term entered by the user.
     * @return The nth term of the Fibonacci Series.
     */
    public static int fib(int n)
    {
        if(n <= 1)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the nth term of the Fibonacci Series.
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
                    if(x <= 0)
                        System.out.println("Must Enter a Number Greater than 0! Try again!");
                }
                while(x <= 0);
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