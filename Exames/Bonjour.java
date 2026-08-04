//Questao01
import java.util.Scanner;

public class Bonjour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Bonjour " + nom);
        System.out.println("Vous avez " + age + " ans.");
        System.out.println("D'ici 10 ans, vous aurez " + (age + 10) + " ans.");
        sc.close();
    }
}
