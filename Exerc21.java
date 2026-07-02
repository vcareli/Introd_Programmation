//Exerc21
import java.util.*;

class Exerc21 {
    public static void main(String[] args){
        List<String> lista = new ArrayList<>(Arrays.asList("Pomme", "Waka-waka", "Banane", "pomme", "kiwi", "Cerise", "abricot", "Datte"));
        lista.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(lista);
    }
}
