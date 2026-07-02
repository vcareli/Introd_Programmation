//Exerc17
public class Exerc17 {
	public static void main(String[] args) {
		final int NBRE = 10;
		int i = 0;
		double harmonique = 0;
		System.out.println("somme des " + NBRE + " premiers termes de la série harmonique");
		while(i < NBRE) {
			harmonique += (double)1/(i+1);
			i++;
		}
		System.out.println("Somme : " + harmonique);
	}
}
