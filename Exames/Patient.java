//Exercice liee Medecin.java
package Medecin.java;
import java.util.*;

public class Patient {
	private String nom;
	private int age;
	private char sexe;
	private Medecin medecin;

	public Patient(String nom, int age, char sexe) {
		this.nom = nom;
		this.age = age;
		this.sexe = sexe;
	}

	public String getNom() {
		return this.nom;
	}

	public int getAge() {
		return this.age;
	}

	public char getSexe() {
		return this.sexe;
	}

	public boolean setAge(int age) {
		if (age >= 18) {  //atendimento de pacientes adultos
			this.age = age;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String ret;
		if (this.medecin != null)
			ret = "Nom : " + this.nom + " - Age : " + this.age + " - Sexe : " + this.sexe + "\n" + "Medecin responsable : " + this.medecin.getNom();
		else
			ret = "Nom : " + this.nom + " - Age : " + this.age + " - Sexe : " + this.sexe;
		return ret;
	}
    
	public void setMedecin(Medecin medecin) {
		medecin.ajouterPatient(this);
		this.medecin = medecin;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}
}
