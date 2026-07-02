//Exerc9
import java.util.*;

public class Exerc9 {
	void main() {
		ArrayList<Integer> tab = new ArrayList<Integer>(Arrays.asList(4,6,9,1,2,76,222,5,22));
		tab.sort(Comparator.naturalOrder());
		System.out.println(tab); // Vai exibir em ordem natural
	}
}
