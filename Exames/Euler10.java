//q10
public class Euler10 {
	public static boolean test_prime(int num) {
		if (num == 2)
			return true;
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long sum = 2L;		//Inicia com o primeiro primo par
		int i = 3;
		while (i <= 2000000) {
			if (test_prime(i))
				sum += i;
			i += 2;
		}
		System.out.println("Tous les nombres primes ad 2 millions = " + sum);
	}
}
