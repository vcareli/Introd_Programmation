//Questao 2
import java.util.Scanner;

public class Note {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entree votre note (0 - 100): ");
		int note = sc.nextInt();
		while (note < 0 || note > 100) {
			System.out.println("Note doit etre 0 a 100...");
			System.out.print("Entrez votre note (0 - 100): ");
			note = sc.nextInt();
		}
		if (note < 60) {System.out.print("Echec");}
		if ((note >= 60) && (note < 80)) {System.out.print("Reussite");}
		if (note >= 80) {System.out.print("Tres bien");}
		sc.close();
	}
}
