//Questao 4
import java.util.Scanner;

public class Table {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int[] tableau = new int[10];
		int sup_M = 0;
		System.out.print("Entrez un nombre entier : ");
		tableau[0] = sc.nextInt();
		int petite = tableau[0];
		int grand = tableau[0];
		int somme = tableau[0];
		for(int i = 1; i < 10; i++) {
			System.out.print("Entrez un nombre entier : ");
			tableau[i] = sc.nextInt();
			somme += tableau[i];
			if (tableau[i] < petite) petite = tableau[i];
			if (tableau[i] > grand) grand = tableau[i];
		}
		for(int i = 0; i < 10; i++) {
			if (((double)somme / 10) < tableau[i]) sup_M++;
		}
		System.out.println("Moyenne................: " + ((double)somme / 10));
		System.out.println("Plus Petite............: " + petite);
		System.out.println("Plus grand.............: " + grand);
		System.out.println("Superieur a la moyenne.: " + sup_M);
		sc.close();
	}
}
