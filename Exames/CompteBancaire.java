import java.util.Scanner;

public class CompteBancaire {
	private double solde;
	
	public CompteBancaire(double soldeI) {
		this.solde = soldeI;
	}
	
	public double getSolde() {
		return this.solde;
	}
	
	public void retirer(double montant) throws SoldeInsuffisantException {
		if (this.solde >= montant) {
			this.solde -= montant;
		} else {
			throw new SoldeInsuffisantException("Solde Insuffisant ou montat invalide!");
		}
	}
	
	public static void main(String[] args) {
		CompteBancaire compte = new CompteBancaire(100.0);
		Scanner sc = new Scanner(System.in);
		double montant = 0;
		
		System.out.print("Valeur pour retirer : ");
		montant = sc.nextDouble();
		try {
			compte.retirer(montant);
			System.out.println("Retrait effectue, noveau solde : " + compte.getSolde());
		} catch(SoldeInsuffisantException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
}

class SoldeInsuffisantException extends Exception {
	public SoldeInsuffisantException(String message) {
		super(message);
	}	
}
