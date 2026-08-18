//Exercice liee Medecin.java
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

	public static void main(String[] args) {
		Patient p1 = new Patient("Oceane", 30, 'F');
		Patient p2 = new Patient("François", 25, 'M');
		Patient p3 = new Patient("Katherine", 24, 'F');
		Patient p4 = new Patient("Davi Chatoncio", 18, 'M');
		Medecin m1 = new Medecin("Dr. House", "INFECTO", 12345);
		Medecin m2 = new Medecin("Good doctor", 54321);
		Medecin m3 = new Medecin("Dra. Meredith Grey", "URGENTOLOGUE", 10000);

		/*if (p1.setAge(15))
			System.out.println("Nouvelle age modifié avec succès !");
		else
			System.out.println("L'age invalide, patient doivet être adulte");*/
		p1.setMedecin(m2);
		p2.setMedecin(m1);
		p4.setMedecin(m1);
		/*if (p2.getMedecin() != null)
			System.out.println(p2.getMedecin().getNom());
		else
			System.out.println("Pt n'a pas de médecin!");*/
		System.out.println("=======================");
		System.out.println(p1);
		System.out.println("=======================");
		System.out.println(p2);
		System.out.println("=======================");
		System.out.println(p3);
		System.out.println("=======================");
		System.out.println(p4);
		p3.setMedecin(m2);
		System.out.println("=======================");
		System.out.println(p3);
		System.out.println("=======================");
		//System.out.println("Total patients de " + m1.getNom() + m1.sizeClients());
	}
}
