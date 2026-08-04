import java.util.*;

public class Etudiant{
	private String nom = "";
	private double note = 0;
	
	public Etudiant(String nom, double note){
		this.nom = nom;
		this.note = note;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public double getNote(){
		return this.note;
	}
	
	public boolean estAdmis(){
		return (this.note >= 60.0);
	}
	
	public static void main(String[] args) {
		List<Etudiant> liste = new ArrayList<>();
		liste.add(new Etudiant("Alice", 75.0));
		liste.add(new Etudiant("Oceane", 59.0));
		liste.add(new Etudiant("Camille", 60.0));
		for (Etudiant e : liste){
			if (e.estAdmis()){
				System.out.println(e.getNom());
			}
		}
	}
}
