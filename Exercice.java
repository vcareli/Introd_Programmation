// Q21
public class Exercice {
    protected int numeroExercice = 1;
    protected boolean reussi = false;
    public short resultat = 0;
    public static void main(String[] args) {
        Exercice e1 = new Exercice();
        e1.resultat = 80;
        Exercice e2 = new Exercice();
        e2.resultat = 30;
        System.out.println("e1.resultat: " + e1.resultat);
    }
}
