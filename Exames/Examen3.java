//Question 3
import java.util.*;
public class Examen3 {
	public static void main(String[] args) {
		int[] num = {1, 2, 2, 3, 4, 4, 4, 5, 6, 3};
		elem_duplicate(num);
	}
	
	public static void elem_duplicate(int[] tab) {
		ArrayList<Integer> printe = new ArrayList<>();
		System.out.print("Element(s) duplicate(s) : ");
		for (int i = 0; i < tab.length; i++) {
			int rep = 0;
			for (int j = i + 1; j < tab.length; j++) {
				if (tab[i] == tab[j] && !printe.contains(tab[i])){
					rep = tab[i];
					printe.add(rep);
					break;
				}
			}
			if (rep != 0)
				System.out.print(rep + " ");
		}
	}
}
