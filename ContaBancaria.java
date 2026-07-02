public class ContaBancaria {
   // Atributo SEM static. Cada objeto terá o seu próprio saldo.
    double saldo;
    static int totalDeContas = 0;

    ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        totalDeContas++;
    }
    public static void main(String[] args) {
        // Criando duas contas separadas
        ContaBancaria contaAna = new ContaBancaria(1000.0);
        ContaBancaria contaBob = new ContaBancaria(500.0);

        // Modificando apenas o saldo da Ana
        contaAna.saldo = 1200.0;

        // O saldo do Bob continua intacto
        System.out.println("Saldo da Ana: R$ " + contaAna.saldo); // Saída: 1200.0
        System.out.println("Saldo do Bob: R$ " + contaBob.saldo); // Saída: 500.0
        //System.out.println("Total de contas: " + contaBob.totalDeContas);
        System.out.println("Total de contas: " + ContaBancaria.totalDeContas);
    }
}
