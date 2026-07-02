/**************************************
** Travail noté 2 – INF 1220
** Nom : Vieira Careli
** Prénom : Vinicius
** Numéro d'étudiant : 26147256
** Date de remise :04/juin/2026
***************************************/

public class Cercle{
	/*	Private - pour proteger la constant PI et empecher les modifications
		Static - constant PI appartient justa a cette classe
		final - Pour garantir la l'immuabilite de la constante PI
	*/
	private static final double PI = 3.1416;
	private double rayon;	//S'assurer que le rayon soit modifié juste par le constructor

	public Cercle(double rayon){
		this.rayon = (rayon <= 0) ? 0 : rayon;
	}

	public double aire(){
		return this.rayon * this.rayon * PI;
	}

	public double perimetre(){
		return 2 * this.rayon * PI;
	}
}