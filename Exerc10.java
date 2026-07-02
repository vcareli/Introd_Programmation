//Exerc10
import java.util.*;

public class Exerc10 {
	public static <T> ArrayList<T> copie_reverse(ArrayList<T> tab) {
		ArrayList<T> copie = new ArrayList<T>(tab);
		Collections.reverse(copie);
		return copie;
	}

	public static void main(String[] args) {
		ArrayList<Integer> tableau = new ArrayList<Integer>(Arrays.asList(4,6,9,1,2,76,222,5,22));
		System.out.println("Ordre original: " + tableau);
		System.out.println("Ordre Reverse: " + copie_reverse(tableau));
	}
}

/*import java.util.ArrayList;

public class ArrayListUtils {
    
    public static ArrayList inverser(ArrayList liste) {
        
        ArrayList inverse = new ArrayList();
        
        for(Object o : liste) {
            
            inverse.add(0, o);
        }
        
        return inverse;
    }
    
    public static void main(String[] args) {
        
        ArrayList<String> test = new ArrayList<String>();
        test.add("1");
        test.add("32");
        test.add("34");
        test.add("45");
        test.add("5");
        
        ArrayList<String> testInverse = ArrayListUtils.inverser(test);
        
        for(String s : testInverse) {
            
            System.out.print(s + " ");
        }
    }
    
}
*/
