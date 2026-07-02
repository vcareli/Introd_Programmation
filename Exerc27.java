//Exerc27
import java.util.HashMap;

public class Exerc27 {
    static void main(String[] args) {
        //Declara variavel
        HashMap<String, Double> nEleve = new HashMap<>();
        //Adiciona
        nEleve.put("Vinny", 9.5);
        nEleve.put("Deby", 10.0);
        //Puxa dados
        System.out.println("Nota da Deby: " + nEleve.get("Deby"));
    }
}
