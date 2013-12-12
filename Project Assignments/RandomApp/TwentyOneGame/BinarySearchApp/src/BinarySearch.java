
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int searchKey = 7;
		if(binarySearch(arr, searchKey))
			System.out.println("The value is found!");
		else
			System.out.println("The value couldn't be found!");

	}
	
	public static boolean binarySearch(int[] array, int value)
	{
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int curIn;
		
		while(true)
		{
			curIn = (lowerBound + upperBound) / 2;
			if(array[curIn] == value)
				return true;                        // found it
			else if(lowerBound > upperBound)
				return false;                       // con't find it
			else                                    // divide range
			{
				if(array[curIn] < value)
					lowerBound = curIn + 1;         // it's in upper half
				else
					upperBound = curIn - 1;         // it's in lower half
			}
		}
	}
}
