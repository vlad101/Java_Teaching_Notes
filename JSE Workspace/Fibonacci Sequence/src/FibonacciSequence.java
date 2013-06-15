import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the number of terms of fibonacii terms to be printed: ");
		int num= Integer.parseInt(keyboard.nextLine());
		for(int i = 1; i <= num; i++)
		         System.out.println(fib(i));

	}

	public static int fib(int x){
		if(x <=1) 
			return x;
		else 
			return fib(x - 1) + fib(x - 2); 
		}
}
