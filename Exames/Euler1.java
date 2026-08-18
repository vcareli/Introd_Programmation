public class Euler1 {
	public static void main (String[] args) {
		int somme = 0;
		for (int i = 0; i < 1001; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				somme += i;
		}
		System.out.print("Somme : " + somme);
	}
}
