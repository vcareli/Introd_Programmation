//q 7
public class Euler7 {
	public static void main(String[] args) {
		/*if (test_prime(100))
			System.out.println("Prime!");
		else
			System.out.println("Non Prime!");*/
		System.out.println("Le 100001eme nombre prime est : " + trouver_prime(10001));
		System.out.println();
	}
	
	public static boolean test_prime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static int trouver_prime(int limit) {
		int prime = 13;
		int compte = 6;
		while (compte < limit) {
			prime += 2;
			if (test_prime(prime))
				compte++;
		}
		return prime;
	}
}
