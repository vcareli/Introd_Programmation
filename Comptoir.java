public class Comptoir {
// Variable a le modificateur static.
static int totalObjects = 0;
Comptoir() {
totalObjects++; // Compte les objects
}
public static void afficherTotal() {
System.out.println("Total des objects: " + totalObjects);
}
public static void main(String[] args) {
Comptoir c1 = new Comptoir();
Comptoir c2 = new Comptoir();
Comptoir c3 = new Comptoir();
Comptoir.afficherTotal(); // Affiche le total des objects
}
}
