//Exerc18
import java.util.Scanner;
public class Exerc18 {
	public static void main(String[] args) {
		System.out.println("Donnez un nombre entier");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		switch (n) {
			case 10:
				System.out.println("Le nombre vaut 10");
				break;
			case 100:
				System.out.println("Le nombre vaut 100");
				break;
			case 1000:
				System.out.println("Le nombre vaut 1000");
				break;
			default:
				System.out.println("Le nombre  n'est pas une puissance de 10 ou il est plus grand que 1000");
				break;
		}
	}
}
