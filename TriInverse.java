import java.util.Arrays;
import java.util.Comparator;

public class TriInverse {
	public static void main(String[] args) {
		String[] mots = {"banane", "paralelepipedo", "pomme", "zumbi", "ananas", "cerise"};
		System.out.println("Ordem normal: " + Arrays.toString(mots));
		Arrays.sort(mots, Comparator.reverseOrder());
		System.out.println("Ordem inversa - reverseOrde: " + Arrays.toString(mots));
		Arrays.sort(mots, Comparator.naturalOrder());
		System.out.println("Ordem natural: " + Arrays.toString(mots));
	}
}
