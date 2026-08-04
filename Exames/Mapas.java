import java.util.*;

public class Mapas {
	public static void main(String[] args) {
		double[] notes = {60.2, 90.0, 85.4, 13.75, 90.1, 60.2, 13.75};
		Map<Double, Integer> frequence = new HashMap<>();

		for (double n : notes) {
			if (frequence.containsKey(n)) {
				int cont = frequence.get(n);
				frequence.put(n, cont + 1);
			} else {
				frequence.put(n, 1);
			}
		}
		for (double n : frequence.keySet()) {
			System.out.println("Note : " + n + " | Fréquence : " + frequence.get(n));
		}
	}
}
