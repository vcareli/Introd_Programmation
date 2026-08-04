//questao 3
import java.util.Scanner;

public class AnalyseNombres {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez des nombres entiers positifs (et entrez un nombre negatif pour finir la liste :");
		int num = 0;
		int compteur = 0;
		int somme = 0;
		int aux = 0;
		while (num >= 0) {
			num = sc.nextInt();
			if (num >= 0) {
				compteur++;
				somme += num;
				if (aux < num) aux = num;
			}
		}
		//compteur--;
		System.out.println("Vous avez entré " + compteur + " nombre(s)");
		if (compteur > 0) {
			System.out.println("La moyenne est : " + ((double)somme/compteur));
		} else {
			System.out.println("Impossible calculer la moyenne, aucun nombre positif.");
		}
		System.out.println("Le plus grand nombre est : " + aux);
		sc.close();
	}
}
