//Questao 3
import java.util.Scanner;

public class Boucles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez un nombre entier plus grand que 1: ");
		int num = sc.nextInt();
		int i;
		int somme = 0;
		int pairs = 0;
		double moyenne = 0.0;
		for (i = 1; i <= num; i++){
			somme += i;
			if (i % 2 == 0) pairs++;
		}
		moyenne = (double)somme / num;
		System.out.println("Somme des nombres entiers de 1 a " + num + " = " + somme);
		System.out.println("Moyenne = " + moyenne);
		System.out.println("De 1 a " + num + " il y a " + pairs + " nombre(s) pair(s).");
		sc.close();
	}
}
