public class PrimeNumber {

	public static void main(String[] args) {
		int num;
		for(num = 0; num <= 100; num++){
			isPrime(num);
		}
	}
	
	public static void isPrime(int n){
		int count = 0;
		for(int i = 1; i <= n; i++){
			if(n % i == 0)
				count++;
		}
		if(count <= 2)
			System.out.printf("\n%d is a prime number!", n);
	}
}
