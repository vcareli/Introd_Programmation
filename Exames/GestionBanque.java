//questao 10
//questao 7
public class GestionBanque {
	public static void main(String[] args) {
		CompteBancaire compte1 = new CompteBancaire("01-1", "Anne", 1000);
		compte1.afficherInformations();
		System.out.println("--------------------------------");
		/*CompteBancaire compte2 = new CompteBancaire("02-1", "Mel", 500);
		compte1.afficherInformations();
		System.out.println("--------------------------------");
		compte2.afficherInformations();
		System.out.println("--------------------------------");
		compte1.virerVers(compte2, 150);
		compte1.afficherInformations();
		System.out.println("--------------------------------");
		compte2.afficherInformations();
		compte2.virerVers(compte1, 8000);*/
		CompteEpargne compteE1 = new CompteEpargne("01-2", "Anne", 100, 0.05);
		compteE1.afficherInformations();
		System.out.println("--------------------------------");
		compteE1.calculerInterets();
		compteE1.afficherInformations();
	}
}

class CompteBancaire {
	private String numeroCompte;
	private String titulaire;
	private double solde;
    
	public CompteBancaire(String numeroCompte, String titulaire, double solde) {
		this.numeroCompte = numeroCompte;
		this.titulaire    = titulaire;
		this.solde        = solde;
	}
    
	public String getNumeroCompte() {
		return numeroCompte;
	}
    
	public String getTitulaire() {
		return titulaire;
	}
    
	public double getSolde() {
		return solde;
	}
    
	public void deposer(double montant) {
		solde += montant;
	}
    
	public void retirer(double montant) {
		if (solde < montant) {
			System.out.println("Solde indisponible, retrait impossible.");
		} else {
			solde -= montant;
		}
	}

	//questao 8
	public void virerVers(CompteBancaire cible, double montant) {
		if (this.solde < montant) {
			System.out.println("Solde indisponible, impossible virer $" + montant);
		} else {
			this.retirer(montant);
			cible.deposer(montant);
			System.out.println("Virement de $" + montant + " effectué avec succès.");
		}
	}
	
	public void afficherInformations() {
		System.out.println("Compte n..: " + getNumeroCompte());
		System.out.println("Titulaire.: " + getTitulaire());
		System.out.println("Solde.....: " + getSolde());
	}
}

//questao 9
class CompteEpargne extends CompteBancaire {
	private double tauxInteret;
	
	public CompteEpargne(String numeroCompte, String titulaire, double solde, double tauxInteret) {
		super(numeroCompte, titulaire, solde);
		this.tauxInteret = tauxInteret;
	}
	
	public void calculerInterets() {
		double interet = super.getSolde() * (tauxInteret);
		super.deposer(interet);
	}
	
	@Override
	public void afficherInformations() {
		System.out.println("Compte Epargne.: " + super.getNumeroCompte());
		System.out.println("Titulaire......: " + super.getTitulaire());
		System.out.println("Solde..........: " + super.getSolde());
		System.out.println("Interet........: " + (tauxInteret * 100) + "%");
	}
}
