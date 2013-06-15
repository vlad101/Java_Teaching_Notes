public class MergeSort 
{	
	public static void display(int[] array)
	{	
		for(int j = 0; j < array.length; j++)
			System.out.print(array[j] + " ");
		System.out.println();	
	}
	
	public static void mergeSort(int[] array, int lowerBound, int upperBound)
	{
		int low = lowerBound;
		int high = upperBound;
		if(lowerBound >= upperBound)
			return;
		int middle = ( lowerBound + upperBound ) / 2;
		mergeSort(array, low, middle);
		mergeSort(array, middle + 1, high);
		int end_low = middle;
		int start_high = middle + 1;
		while(low <= end_low && start_high <= high)
		{
			if(array[low] < array[start_high])
				low++;
			else
			{
				int temp = array[start_high];
				for(int k = start_high - 1; k >= low; k--)
					array[k + 1] = array[k];
				array[low] = temp;
				low++;
				end_low++;
				start_high++;	
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[] array = {1,3,6,2};
		display(array);
		mergeSort(array, 0, array.length - 1);
		display(array);
	}
}
