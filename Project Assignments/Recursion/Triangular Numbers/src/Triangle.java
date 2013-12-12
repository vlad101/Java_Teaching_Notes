/**
 * The Recursive Pascal's Triangle.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the Pascal's Triangle series.
 */

import java.util.Scanner;

public class Triangle 
{
    public static void main(String[] args)
    {
        // Get the nth term for the Pascal's triangle series
        int num = getTerm();
        
        // Display the term
        displayTerm(num);
        
        // Display the first 10 values of the series.
        displaySeries();
    }
    
    /**
     * Displays the nth term of the Pascal's Triangle.
     * @param n The nth term of the Pascal's Triangle series.
     */
    public static void displayTerm(int n)
    {
        System.out.println("The " + n + " term of the Pascal's triangle is " + triangle(n));
    }
    
    /**
     * The getTerm method returns the nth term entered by the user.
     * @return The term entered by the user. 
     */
    public static int getTerm()
    {
        return validateInteger("Enter the term for the Pascal Triangle series: ");
    }
    
    /**
     * The displaySeries method displays the first ten terms of the Pascal's Triangle Series.
     */
    public static void displaySeries()
    {
        System.out.println("\nThe first 10 terms of the Pascal's Triangle: ");
        for(int i = 1; i < 11; i++)
        {
            if(i == 10)
                System.out.print(triangle(i) + "\n");
            else
                System.out.print(triangle(i) + ", ");
        }
    }
    
    /**
     * The triangle method gets the value of the nth term of the Pascal's Triangle.
     * @param n The nth term entered by the user.
     * @return The nth term of the Pascal's Triangle.
     */
    public static int triangle(int n)
    {
        if(n <= 1)
            return n;
        else
            return n + triangle(n - 1);
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the nth term of the Pascal's Triangle.
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
                    if(x < 1)
                        System.out.println("Must Enter a Number Greater than 0! Try again!");
                }
                while(x < 1);
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