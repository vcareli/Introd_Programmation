/*
Écrivez une classe représentant une valeur entière. Cette classe doit
n'avoir qu'une seule méthode appelée « additionne » qui prend comme
paramètre une instance de la classe et qui retourne une nouvelle
instance de la classe. L'instance retournée doit comprendre la somme des
deux valeurs entières.
*/

public class Valeur{
	private int n = 0;
	
	public Valeur(int n){
		this.n = n;
	}
	public Valeur additionne(Valeur num){
		int soma = this.n + num;
		return new Valeur(soma);
	}
}
