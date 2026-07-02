//Exerc11
import java.util.*;

public class Exerc11 {
	public static <T> ArrayList<T> fusion(ArrayList<T> tab1, ArrayList<T> tab2) {
		ArrayList<T> f = new ArrayList<T>(tab1);
		f.addAll(tab2);
		return f;
	}

	public static void main(String[] args) {
		ArrayList<Integer> tableau1 = new ArrayList<Integer>(Arrays.asList(4,6,9,1,2));
		ArrayList<Integer> tableau2 = new ArrayList<Integer>(Arrays.asList(76,222,5,22));
		System.out.println("original 1: " + tableau1);
		System.out.println("original 2: " + tableau2);
		System.out.println("Fusao: " + fusion(tableau1, tableau2));
		System.out.println("original 1 après fusion: " + tableau1);
		System.out.println("original 2 après fusion: " + tableau2);
	}
}
