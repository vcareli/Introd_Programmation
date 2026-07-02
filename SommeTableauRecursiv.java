//Exerc04 recursivité

public class SommeTableauRecursiv {
	
	static int sumtab(int[] tab, int tam) {
		if (tam == 0) return 0;
		else return tab[tam-1] + sumtab(tab, tam - 1);
	}
	
	public static void main(String[] args) {
		int[] tableau = {84, 15, 42, 7, 91, 33, 58, 22, 69, 4, 77, 12, 49, 88, 26, 53, 9, 64, 38, 95, 17, 46, 72, 31, 81, 14, 61, 29, 98, 41, 5, 86, 20, 56, 75, 2, 67, 36, 93, 24, 48, 83, 11, 60, 39, 79, 27, 52, 99, 19};
		
		System.out.println("Soma do tableau: " + sumtab(tableau, tableau.length));
	}
}
