public class Examen2 {
    public static void main(String[] args) {
        int somme = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0) somme += i;
        }
        System.out.print(somme);
    }
}
