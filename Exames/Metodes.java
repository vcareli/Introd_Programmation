//Questao 5
import java.util.Scanner;

public class Metodes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez 1er nombre entier : ");
		int a = sc.nextInt();
		System.out.println("Entrez 2eme nombre entier : ");
		int b = sc.nextInt();
		System.out.println("a + b = " + addition(a, b));
		System.out.println("a * b = " + multiplication(a, b));
		/*if (estPair(a)) {
			System.out.println(a + " est Pair");
		} else {System.out.println(a + " est impair");}*/
		System.out.println(a + (estPair(a) ? " est pair." : " est impair."));
		System.out.println(b + (estPair(b) ? " est pair." : " est impair."));
		sc.close();
	}
	
	public static int addition(int a, int b){
		return a + b;
	}
	
	public static int multiplication(int a, int b){
		return a * b;
	}
	
	public static boolean estPair(int n){
		return ((n % 2) == 0);
	}
}


