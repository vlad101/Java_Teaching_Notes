/**
 * The Recursive Addition of the array Elements.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the 
 * determining the sum of the array elements.
 */

import java.util.Scanner;

public class SumArray
{
    public static void main(String[] args)
    {
        // Get the Number of Elements to be entered
        int size = getNumElems();
        
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) // For each item number get the value
            arr[i] = getNum();        // Get the numbers
       
        // Calculate the sum of the elements of the array
        int sum = sumElems(arr, 0, arr.length - 1);
        
        // Display the sum of the elements of the array
        displayResult(sum);
    }
    
    /**
     * The displayResult method displays the sum of the array elements.
     * @param num The sum of the elements of the array.
     */
    public static void displayResult(int num)
    {
        System.out.println("The sum of all the elements in the array is " + num);
    }
    
    /**
     * The sumElems method calculates the sum of the array elements.
     * @param a The array that holds integer values.
     * @param start The first position of the array.
     * @param end The last position of the array.
     * @return The sum of the integers of the array.
     */
    public static int sumElems(int[] a, int start, int end)
    {
        if(start > end)
            return 0;
        else
            return a[start] + sumElems(a, start + 1, end);
    }
    
    /**
     * @return The integer values entered by the user.
     */
    public static int getNum()
    {
        return validateInteger("Enter the value: ");
    }
    
    /**
     * @return The amount of the integers that is to be added 
     * to the array, the size of the array.
     */
    public static int getNumElems()
    {
        return validateInteger("How many integers would you like to enter? ");
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the elements of the array.
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