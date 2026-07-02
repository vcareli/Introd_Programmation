/*
Proposez une classe Etudiant dont le constructeur prend en paramètre
un identifiant (sous la forme d'un entier) et qui comprend une méthode
monIdentifiant retournant l'identifiant en question.
*/

public class Etudiant{
	int e_Id;
	String nom;
	String prenom;

	public Etudiant(int e_Id, String nom, String prenom){
		this.e_Id = e_Id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int monIdentifiant(int e_Id){
		return this.e_Id;
	}
}
