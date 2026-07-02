/*
Écrivez une classe représentant une valeur entière à laquelle je peux
ajouter la valeur trois par l'entremise d'une méthode « public » nommée
« patate ». La méthode doit retourner la valeur entière modifiée.
Le constructeur doit me permettre d'initialiser la valeur entière. La
classe doit n'avoir que des attributs « private ».
*/

public class Valeur{
	private int n = 0;
	
	public Valeur(int n){
		this.n = n;
	}
	public int Patate(){
		n += 3;
		return n;
	}
}
