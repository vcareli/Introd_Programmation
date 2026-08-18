//q3
public class Euler4 {
	public static void main(String[] args) {
		long divisor = 2L;
		long n = 600851475143L;
		while (n != 1) {
			while(n % divisor == 0) {
				n = n / divisor;
			}
			divisor++;
		}
		System.out.println("Plus grand prime : " + (divisor - 1));
	}
}
