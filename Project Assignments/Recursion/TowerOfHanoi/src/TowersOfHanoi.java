/**
 * The Recursive Simulation of the Towers of Hanoi Game.
 * @author: Vladimir Efros
 * This program gives a simple demonstration of the 
 * Solution to the Towers of Hanoi Game.
 */

import java.util.Scanner;

public class TowersOfHanoi
{
    public static void main(String[] args)
    {
        // Get the number of discs
        int numDiscs = getNumDiscs();
        
        // move num number of discs from the peg 1 to peg 3 using peg 2
        hanoi(numDiscs, 1, 3, 2);
    }
    
    /**
     * @return The number of the Discs to be moved.
     */
    public static int getNumDiscs()
    {
        return validateInteger("Enter the number of the discs to be moved: ");
    }
    
    /**
     * The hanoi method displays solution to the Towers of Hanoi game.
     * @param n The number of discs.
     * @param peg1 The peg #1 - move discs from.
     * @param peg3 The peg #3. - move discs to.
     * @param peg2 The peg #1 - temporary peg. 
     */
    public static void hanoi(int n, int peg1, int peg3, int peg2)
    {
        if(n > 0)
        {
            hanoi(n - 1, peg1, peg2, peg3);
            System.out.println("Move the disc from peg " + peg1 + " to peg " + peg3);
            hanoi(n - 1, peg2, peg3, peg1);
        }
    }
    
    /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the number of the discs to be moved.
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