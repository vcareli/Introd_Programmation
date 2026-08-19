//liees patient et medecin
package Patient.java;
package Medecin.java;
import java.util.*;

public class Hopital {
	private ArrayList<Medecin> medList;
	private ArrayList<Patient> cliList;

	public Hopital() {
		this.medList = new ArrayList<>();
		this.cliList = new ArrayList<>();
	}

	public boolean registreMed(Medecin... med) {
		for (Medecin medecin : med) {
			if (medecin != null) this.medList.add(medecin);
		}
		return true;
	}

	public boolean registrePt(Patient... cli) {
		for (Patient client : cli) {
			if (client != null) this.cliList.add(client);
		}
		return true;
	}

	public ArrayList<Medecin> chercheMd(String specialite) {
		ArrayList<Medecin> listMd = new ArrayList<>();
		for (Medecin medecin : this.medList) {
			if (medecin.getSpecialite().equals(specialite))
				listMd.add(medecin);
		}
		return listMd;
	}

	public static void main(String[] args) {
		Patient p1 = new Patient("Oceane", 30, 'F');
		Patient p2 = new Patient("François", 25, 'M');
		Patient p3 = new Patient("Katherine", 24, 'F');
		Patient p4 = new Patient("Davi Chatoncio", 18, 'M');
		Medecin m1 = new Medecin("Dr. House", "INFECTO", 12345);
		Medecin m2 = new Medecin("Good doctor", 54321);
		Medecin m3 = new Medecin("Dra. Meredith Grey", "URGENTOLOGUE", 10000);
        Medecin m4 = new Medecin("Dr. Shawn Murf", "URGENTOLOGUE", 00001);
        Hopital h1 = new Hopital();
        if (h1.registreMed(m1, m2, m3, m4))
			System.out.print("registro medecin ok");
		if (h1.registrePt(p1, p2, p3, p4))
			System.out.print("registro patient ok");
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
		System.out.println("Total patients de " + m1.getNom() + " : " + m1.sizeClients());
		System.out.println("Total patients de " + m2.getNom() + " : " + m2.sizeClients());
		System.out.println("Total patients de " + m3.getNom() + " : " + m3.sizeClients());
		System.out.println("Total patients de " + m4.getNom() + " : " + m4.sizeClients());
		System.out.println("=======================");
		ArrayList<Medecin> list = h1.chercheMd("URGENTOLOGUE");
		System.out.println(list);
		
	}
}
