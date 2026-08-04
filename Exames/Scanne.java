import java.util.Scanner;

public class Scanne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double valeur = 500.0;
		String nom = "";
		int age = 0;
		System.out.print("Entree votre nom : ");
		nom = sc.nextLine();
		System.out.print("Entree votre age : ");
		age = sc.nextInt();
		System.out.println("Nom : " + nom + " - Age : " + age);
		System.out.printf("Valeur sans rabais : %.2f\n", valeur);
		if (age < 18) {
			valeur = (1 - 0.15) * valeur ;
			System.out.printf("Valeur avec rabais : %.2f\n", valeur);
		}
		sc.close();
	}
}
