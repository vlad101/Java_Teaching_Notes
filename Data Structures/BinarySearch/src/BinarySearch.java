/**
 * The Recursive Binary Search.
 * @author: Vladimir Efros
 * This program demonstrates a Binary Search of the array element.
 */

public class BinarySearch 
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchValue = 1;
        if(binarySearch(arr, searchValue))
            System.out.println("Found!");
        else
            System.out.println("Not Found!");
    }

    /**
     * The binarySearch method searches for the element in the array.
     * @param a The array where the value will be searched.
     * @param searchKey The value that is searched for.
     * @return true if the element is found, otherwise return false.
     */
    public static boolean binarySearch(int[] a, int searchKey)
    {
        int lowerBound = 0;
        int upperBound = a.length - 1;
        int curIn;
        
        while(true)
        {
            curIn = (lowerBound + upperBound) / 2;
            if(a[curIn] == searchKey)
                return true;
            else if(lowerBound > upperBound)
                return false;
            else
            {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }
}