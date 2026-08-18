//q4
public class Euler4 {
	public static void main(String[] args) {
		int n = 0;
		int pg = 0;
		for (int i = 999; i >= 100; i--) {
			for (int j = i - 1; j >= 100; j--) {
				n = i * j;
				if (n <= pg)
					break;
				if (n == inverter_num(n))
					pg = n;
			}
		}
		System.out.println(pg + " c'est le plus grand palindrome!");
	}
	
	public static int inverter_num(int num) {		//Criar um numero invertido
		int num_inverse = 0;
		while (num != 0) {
			num_inverse = (num_inverse * 10) + (num % 10);
			num /= 10;
		}
		return num_inverse;
	}
}
