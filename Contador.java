public class Contador {
    // Variável compartilhada por todos os objetos
    static int totalObjetos = 0;

    public Contador() {
        totalObjetos++;
    }

    // Método estático
    public static void mostrarTotal() {
        System.out.println("Total de objetos: " + totalObjetos);
    }

    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        Contador.mostrarTotal();
    }
}
