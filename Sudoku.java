import java.util.Random;

public class Sudoku {
	//Un tableau int[9][9] public
	//accessible à toutes les méthodes de ma classe Sudoku.
	public int[][] matriz = new int[9][9];

	void nettoyer(int l) { //Méthode pour nettoyer un ligne lorsque un chiffre est répété
		for (int j = 0; j < matriz.length; j++) {
			matriz[l][j] = 0;	//0 a toute la ligne pour recommencer le boucle
		}
	}

	boolean valider(int l, int c, int n) { //Méthode pour valider s'il y a des chiffres répété
		int lI = (l/3) * 3;
		int cI = (c/3) * 3;
		for (int i = 0; i < matriz.length; i++) {
		//Le 1er for va explorer la ligne pour chercher des chiffres répétés
			if ((matriz[l][i] == n))
				return false;
		}
		for (int j = 0; j < matriz.length; j++) {
		//Le 2eme for va explorer la colonne pour chercher des chiffres répétés.
			if ((matriz[j][c] == n))
				return false;
		}
		for (int i = lI; i < lI + 3; i++) {
			for (int j = cI; j < cI + 3; j++) {
				if (matriz[i][j] == n)
					return false;
			}
		}
		return true;
	}

	void creer_matrix() {	//Méthode pour créér le tableau
		Random pere = new Random();
		int n;
		int limit;	//limiter le temps pour valider une ligne ou colonne

		for (int i = 0; i < matriz.length; i++) {	//Les deux boucles pour explorer le tableau
			for (int j = 0; j < matriz.length; j++) {
				limit = 0;
				n = pere.nextInt(9) + 1;	//Reçoit un numero aléatoire de 1 a 9
				while (!valider(i, j, n)) {	//valide dans la rangée et la colonne auxquelles elle appartient.
					n = pere.nextInt(9) + 1;
					limit++;
					if (limit > 3000)	//Si cela prend trop de temps pour valider, sors de la boucle while.
						break;
				}
				if (limit < 3000)
					matriz[i][j] = n;	//stocker le nombre dans le tableau
				else{
					nettoyer(i);	//Mettre dans la rangée et recommence la ligne
					j = -1;
				}
			}
		}
	}

	void afficher(){	//Méthode pour afficher le tableau
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + " ");
				if (j == 2 || j == 5)
					System.out.print(" | ");
			}
			System.out.println();
			if (i == 2 || i == 5)
				System.out.println("_______________________");
		}
	}

	public static void main(String[] args) {
		//Main et appel des méthodes
		Sudoku matrix = new Sudoku();
		matrix.creer_matrix();
		matrix.afficher();
	}
}
