import java.util.Arrays;
import java.util.Comparator;

public class ExempleLongueur {
	// Nouvelle classe Comparator
	static class LongueurComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return a.length() - b.length();
		}
	}

    public static void main(String[] args) {
        String[] mots = {"chat", "éléphant", "chien", "girafe"};
        Arrays.sort(mots, new LongueurComparator());
        System.out.println("Mots triés par longueur : " + Arrays.toString(mots));
    }
}
