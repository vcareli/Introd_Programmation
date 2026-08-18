//Exercice liee Patient.java
public class Medecin {
	private String nom;
	private String specialite;
	private int registre;

	public Medecin(String nom, String specialite, int registre) {
		this.nom = nom;
		this.specialite = specialite;
		this.registre = registre;
	}
    
	public Medecin(String nom, int registre) {
		this.nom = nom;
		this.specialite = "GENERAL";
		this.registre = registre;
	}

	public String getNom() {
		return this.nom;
	}
    
	public String getSpecialite() {
		return this.specialite;
	}

	public int getRegistre() {
		return this.registre;
	}
}
