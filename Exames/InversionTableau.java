//questao 4
import java.util.Scanner;
public class InversionTableau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien des nombres souhaitez vous rentrez : ");
        int n = sc.nextInt();
        if (n > 0) {
			int[] tab = new int[n];
			for (int i = 0; i < n; i++) {
				System.out.print("Entrez le numero : ");
				tab[i] = sc.nextInt();
				System.out.println();
			}
			System.out.println();
			System.out.print("Votre tableau : ");
			for (int i = 0; i < n; i++) {
				System.out.print(tab[i]);
				if (i != n - 1) {System.out.print(" - ");}
			}
			for (int i = 0; i < n / 2; i++) {
				int aux = tab[i];
				tab[i] = tab[n - (i + 1)];
				tab[n - (i + 1)] = aux;
			}
			System.out.println();
			System.out.print("Tableau Inversé : ");
			for (int i = 0; i < n; i++) {
				System.out.print(tab[i]);
				if (i != n - 1) {System.out.print(" - ");}
			}
		} else {System.out.println("Vous ne voulez entree aucune nombre!");}
        sc.close();
    }
}
