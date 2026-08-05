public class E1Q4 {
	public static void main(String[] args) {
		int[] tab = {1, 2, 3, 5};
		System.out.print(moyenneDouble(tab));
	}

	public static double moyenneDouble(int[] tableau) {
		int s = 0;
		int i;
		for (i = 0; i < tableau.length; i++) {
			s += tableau[i];
		}
		return (double)s / i;
	}
}
