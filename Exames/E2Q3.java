import java.util.Scanner;
public class E2Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean t = true;
		System.out.print("Entrez un nombre entier positif: ");
		n = sc.nextInt();
		if (n < 2) t = false;
		else if (n == 2 || n == 3) t = true;
		else if (n % 2 == 0 || n % 3 == 0) t = false;
		for (int i = 5; i * i <= n; i +=6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				t = false;
				break;
			}
		}
		if (t) System.out.println("Nombre premier!");
		else System.out.println("Nombre non premier!");
		sc.close();
	}
}
