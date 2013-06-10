/**
 * The Recursive Power Program.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the 
 * raising a number to a power [positive integers].
 */

import java.util.Scanner;

public class Power
{
    public static void main(String[] args)
    {
        // Get the base number
        int num = getBaseNum();
        
        // Get the exponent
        int exp = getExp();
        
        // Display Result
        displayResult(num, exp);
    }
    
    /**
     * The getBaseNum gets base number from the user.
     * @return The base number.
     */
    public static int getBaseNum()
    {
        return validateInteger("Enter the base number: ");
    }
    
    /**
     * The getExp method gets exponent from the user.
     * @return The exponent.
     */
    public static int getExp()
    {
        return validateInteger("Enter the exponent: ");
    }
    
    /**
     * The displayResult method raises the base number to the exponent.
     * @param n The base number.
     * @param e The exponent.
     */
    public static void displayResult(int n, int e)
    {
        System.out.println(n + " to the power " + e + " is " + power(n, e));
    }
    
    /**
     * The power method raises the number to the power.
     * @param num The base number.
     * @param pow The exponent, where pow >= 0.
     * @return The result of raising num to the exponent pow.
     */
    public static int power(int num, int pow)
    {
        if(pow == 0)
            return 1;
        else
            return num * power(num, pow - 1);
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the base and the exponent.
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