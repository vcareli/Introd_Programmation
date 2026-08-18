//Exercice liee Patient.java
import java.util.*;

public class Medecin {
	private String nom;
	private String specialite;
	private int registre;
	private ArrayList<Patient> clients;

	public Medecin(String nom, String specialite, int registre) {
		clients = new ArrayList<>();
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
	
	public boolean ajouterPatient(Patient client) {
		if (client != null) {
			this.clients.add(client);
			return true;
		}
		return false;
	}
	
	public int sizeClients() {
		return this.clients.size();
	}
}
