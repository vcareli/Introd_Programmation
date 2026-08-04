//questao 2
import java.util.Scanner;

public class EvaluationNote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sit = "";
        System.out.print("Entrez la note : ");
        Double n = sc.nextDouble();
        while (n < 0 || n > 20) {
            System.out.println();
            System.out.println("Note entre 0 et 20");
            System.out.print("Entrez la note : ");
            n = sc.nextDouble();
        }
        System.out.println();
        if (n < 10) sit = "Échec";
        else if (n >= 10 && n < 12) sit = "Passable";
        else if (n >= 12 && n < 14) sit = "Assez bien";
        else if (n >= 14 && n < 16) sit = "Bien";
        else if (n >= 16) sit = "Très Bien";
        System.out.println("Resultat : " + sit);
        sc.close();
    }
}
