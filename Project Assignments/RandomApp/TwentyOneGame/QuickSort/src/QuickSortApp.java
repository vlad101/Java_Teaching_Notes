public class QuickSortApp 
{
	public static void main(String[] args) 
	{
		int[] values = {6,1,9,4};
		for(int element : values)
			System.out.print(element + " ");
		System.out.println();
		quickSort(values);
		for(int element : values)
			System.out.print(element + " ");
	}

	public static void quickSort(int[] array)
	{
		doQuickSort(array, 0, array.length - 1);
	}
	
	private static void doQuickSort(int[] array, int start, int end)
	{
		int pivot = partition(array, start, end);
		doQuickSort(array, start, pivot - 1);
		doQuickSort(array, pivot + 1, end);
	}
	
	private static int partition(int[] array, int start, int end)
	{
		int mid, endOfLeftList, pivot;
		mid = (start + end) / 2;
		swap(array, start, mid);
		pivot = array[start];
		endOfLeftList = start;
		for(int i = start + 1; i <= end; i++)
		{
			if(array[i] < pivot)
			{
				endOfLeftList++;
				swap(array, endOfLeftList, i);
			}
		}	
		
		swap(array, start, endOfLeftList);
		return endOfLeftList;
	}
	
	public static void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}