/**
 * The Recursive Binary Search.
 * @author: Vladimir Efros
 * This program demonstrates a Recursive Binary Search of the array element.
 */

public class BinarySearchRecursion 
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchValue = 0;
        int start = 0;
        int end = arr.length - 1;
        if(binarySearch(arr, searchValue, start, end))
            System.out.println("Found!");
        else
            System.out.println("Not Found!");
    }

    /**
     * The binarySearch method searches for the element in the array using recursion.
     * @param a The array where the value will be searched.
     * @param searchKey The value that is searched for.
     * @param lowerBound Start point of the search.
     * @param upperBound End point of the search.
     * @return true if the element is found, otherwise return false.
     */
    public static boolean binarySearch(int[] a, int searchKey, int lowerBound, int upperBound)
    {
        int curIn = (lowerBound + upperBound) / 2;
        if(a[curIn] == searchKey)
            return true;
        else if(lowerBound > upperBound)
            return false;
        else
        {
            if(a[curIn] < searchKey)
                return binarySearch(a, searchKey, curIn + 1, upperBound);
            else
                return binarySearch(a, searchKey, lowerBound, curIn - 1);
        }
    }
}