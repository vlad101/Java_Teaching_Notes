import java.util.Random;

class TwoDArray
{
	private int[][] array;
	private int rows;
	private int columns;
	
	public TwoDArray(int r, int c)
	{
		rows = r;
		columns = c;
		array = new int[rows][columns];
	}
	
	public void setArray()
	{
		Random random = new Random();
		int count = 0;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				array[i][j] = random.nextInt(10);
	}
		
	public int getTotal(){
		int count = 0;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				count += array[i][j];
		return count;
	}
	
	public double getAverage()
	{
		double count = 0;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				count += array[i][j];
		return count / (rows * columns);
	}
	
	public void getRowTotal()
	{
		double count = 0;
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				count += array[i][j];
			}
			System.out.println("The Total of the Row " + (i + 1) + " is " + count);
			count = 0;
		}
		System.out.println();
	}
	
	public void displayArr()
	{
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++)
				System.out.print(array[i][j] + "   ");
			System.out.println();
		}
		System.out.println();
	}

}
		
public class TwoDArrayApp
{
	public static void main(String[] args)
	{
		final int ROWS = 5;
		final int COLUMNS = 5;
		
		TwoDArray arr = new TwoDArray(ROWS, COLUMNS);
		
		arr.setArray();
		arr.displayArr();
		System.out.printf("The Total is %d\n", arr.getTotal());
		System.out.printf("The Average is %.2f \n", arr.getAverage());
		arr.getRowTotal();
	}
}
