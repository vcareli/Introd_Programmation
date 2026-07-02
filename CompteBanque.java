public class CompteBanque {
	double solde;
	CompteBanque(double solde) {
		this.solde = solde;
	}
	
	public static void main(String[] args) {
		CompteBanque compteAna = new CompteBanque(1000);
		CompteBanque compteBob = new CompteBanque(500);
		compteAna.solde = 1200;
		System.out.println("Saldo da Ana: R$ " + compteAna.solde);
		System.out.println("Saldo do Bob: R$ " + compteBob.solde);
	}
}
