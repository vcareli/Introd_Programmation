import java.util.*;

public class E2Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 0;
		int max = 101;
		int num = impair(min, max);
		boolean ok = false;
		System.out.println("Pensez un nombre entre 0 - 100 impair !");
		question(num);
		char chosen = sc.next().charAt(0);
		if (chosen == 'c' || chosen == 'C') {
			System.out.println("Woowwwww J'ai deviné ton numéro !");
			ok = true;
		}
		while (!ok) {
			if (chosen == 'c' || chosen == 'C') {
			System.out.println("Woowwwww J'ai deviné ton numéro !");
			ok = true;
			break;
		}
			while (chosen != 'C' && chosen != 'c') {
				if (chosen == 'a' || chosen == 'A') {
					max = num;
					num = impair(min, max);
					question(num);
					chosen = sc.next().charAt(0);
				} else if (chosen == 'b' || chosen == 'B') {
					min = num;
					num = impair(min, max);
					question(num);
					chosen = sc.next().charAt(0);
				} else if (chosen == 'c' || chosen == 'C') {
					System.out.println("Woowwwww J'ai deviné ton numéro !");
					ok = true;
					break;
				}
			}
		}
		System.out.println("Le nombre est " + num);
		sc.close();
	}
	
	public static int impair(int min, int max) {	// Nombre aleatoire entre 0 - max impair
		Random rd = new Random();
		int n = rd.nextInt(max);
		while ((n % 2 == 0) || n < min) {
			n = rd.nextInt(max);
		}
		return n;
	}
	
	public static void question(int num) {
		System.out.println("Est-ce que votre numero est " + num + " ?");
		System.out.println("(a) plus petit");
		System.out.println("(b) plus grand");
		System.out.println("(c) identique");
	}
}
