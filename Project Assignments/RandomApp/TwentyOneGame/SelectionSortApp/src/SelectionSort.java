
public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {10,9,8,3};
		displayArray(arr);
		selectionSortArray(arr);
		displayArray(arr);

	}
	
	public static void selectionSortArray(int[] array)
	{
		int out, in, min;
		for(out = 0; out < array.length - 1; out++)                               // outer loop
		{
			min = out;                                                                 // minimum
			for(in = out + 1; in < array.length; in++)                 // inner loop 
				if(array[in] < array[min])                         // if min is greater
					min = in;                                   // we have a new min
			swap(array, out, min);                                              // swap them
                                 }                                                                                               // end for(out)
	}                                                  	                                                  // end Selection
	
	public static void swap(int[] array, int one, int two)
	{
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}

	
	public static void displayArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}
