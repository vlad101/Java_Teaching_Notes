/**
 * The QuickSort Implementation.
 * @author: Vladimir Efros
 * This program implements a QuickSort.
 */

public class QuickSort 
{
    public static void main(String[] args)
    {
        int[] arr = {10, 15, 4, 6, 20};
        displayArr(arr);
        quickSort(arr, 0, arr.length - 1);
        displayArr(arr);
    }
    
    /**
     * The quickSort method is used to sort left and right partition.
     * @param a The array that is to be sorted.
     * @param left The start point of the sort.
     * @param right The end point of the sort.
     */
    public static void quickSort(int[] a, int left, int right)
    {
        int pivot = partition(a, left, right);
        if(left < pivot - 1)
            quickSort(a, left, pivot - 1);
        if(pivot < right)
            quickSort(a, pivot, right);
    }
    
    /**
     * The partition method divides an array into two parts - left and right partitions.
     * @param a The array that is to be sorted.
     * @param l All elements less than a pivot.
     * @param r All elements greater than pivot.
     * @return The pivot value.
     */
    private static int partition(int[] a, int l, int r)
    {
        int pivot = a[(l + r)/ 2];
        while(l <= r)
        {
            while(a[l] < pivot)
                l++;
            
            while(pivot < a[r])
                r--;
            
            if(l <= r)
            {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
        }
        return l;
    }
    
    /**
     * The displayArr method displays all array elements.
     * @param a The array that is to be displayed.
     */
    public static void displayArr(int[] a)
    {
        for(int i : a)
            System.out.print(i + " ");
        System.out.println();
    }
}
