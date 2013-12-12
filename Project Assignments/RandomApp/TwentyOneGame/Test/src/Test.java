
public class Test
{	
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5};
		int searchKey = 6;
		int lowerBound = 0;
		int upperBound = arr.length - 1;
		System.out.println(binarySearch(arr, lowerBound, upperBound, searchKey));
	}
	
	public static int binarySearch(int[] arr, int l, int u, int value)
	{
		int curIn;
		
			curIn = (l + u) / 2;
			if(arr[curIn]== value)
				return 1;
			else if(l > u)
				return 0;
			else
			{
				if(arr[curIn] < value)
					//lowerBound = curIn + 1;
					return binarySearch(arr, curIn + 1, u, value);
				else
					// upperBound = curIn - 1;
					return binarySearch(arr, l, curIn - 1, value);
			}
		
	}
}

