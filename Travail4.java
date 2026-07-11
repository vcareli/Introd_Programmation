//Sudoku fichier TXT
import java.io.*;
import java.util.Scanner;
import java.util.HashSet;

public class Travail4 {
	public static void main(String[] args) throws IOException {
		// Méthode main : Appeller les autres méthodes.
		String filename = "partie4.txt";
		try {
			int[][] sudok = loadGrid(filename);		// Permet d'assigner la grille du fichier à la variable sudok
			System.out.println("Sudoku");
			printGrid(sudok);						// Affiche la grid
			System.out.println();
			System.out.println("Sudoku Transposed");
			printGrid(transposeGrid(sudok));		// Affiche la grid transposée
			System.out.println("Sudoku transposée au fichier : transpose.txt");
			
 		} catch (Exception e) {						// Message d'error (Exception)
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static int[][] loadGrid(String filename) throws IOException {
		// Méthode loadGrid : Charger la grid du fichier dans la mémoire.
		// static: n'utilise pas des attribut de la classe; s'aggit d'un fonction uttilitaire
		int[][] grid = new int[9][9];
		File file = new File(filename);
		Scanner sc = new Scanner(file);			//Ouvrir le fichier avec le méthode scanner
		try {
			while (sc.hasNext()) {				//Parcourez le fichier en utilisant la méthode hasNext
				String triple = sc.next();		//qui s'arrête lorsqu'elle rencontre un espace.
				int l = triple.charAt(0) - '0';				//convertir un char en int
				int c = triple.charAt(1) - '0';
				if ((l > 8) || (l < 0) || (c > 8) || (c < 0))		//validation des colonnes et des rangées
					throw new IllegalArgumentException("Le fichier Sudoku donné n'est pas valide!");
				else
					grid[l][c] = triple.charAt(2) - '0';
			}
			if (!validateGrid(grid))							//Méthode pour valider le fichier
				throw new IllegalArgumentException("Le fichier Sudoku donné n'est pas valide!");
		} finally {
			sc.close();								//Fermer le fichier
		}
		return grid;
	}

	private static boolean validateGrid(int[][] grid) {		//Méthode pour valider les règles du SUdoku et le fichier
		
		//Test des lignes
		for (int i = 0; i < grid.length; i++) {
			HashSet<Integer> blocnotes = new HashSet<>();		//Structure HashSet rejette les doublons dans les lignes
			for (int j = 0; j < grid.length; j++) {
				if (!blocnotes.add(grid[i][j]))
					return false;
			}
		}
		
		//Test des colonnes
		for (int j = 0; j < grid.length; j++) {
			HashSet<Integer> blocnotes = new HashSet<>();		//Structure HashSet rejette les doublons dans les colonnes
			for (int i = 0; i < grid.length; i++) {
				if (!blocnotes.add(grid[i][j]))
					return false;
			}
		}
		
		//Test des mini matriz (3x3)
		for (int lI = 0; lI < 9; lI += 3) {				//Diviser la table en 9 mini-tables (3x3)
			for (int cI = 0; cI < 9; cI += 3) {
				HashSet<Integer> blocnotes = new HashSet<>();	//Structure HashSet rejette les doublons dans les mini tableau (3x3)
				for (int i = lI; i < lI + 3; i++) {
					for (int j = cI; j < cI + 3; j++) {
						if (!blocnotes.add(grid[i][j]))
							return false;
					}
				}
			}
		}
		return true;
	}

	private static int[][] transposeGrid(int[][] grid) throws IOException {		//Méthode pour gérer une matrice transposée
		int[][] transposed = new int[grid.length][grid.length];
		FileWriter f_trans = new FileWriter("transpose.txt");			//Crée le fichier pour sauvegarder la matice transposée
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				transposed[i][j] = grid[j][i];				//Change les lignes pour les colonnes
				f_trans.write(String.valueOf(i));					//Écrire ligne au fichier
				f_trans.write(String.valueOf(j));					//Écrire colonne au fichier
				f_trans.write(String.valueOf(transposed[i][j]));	//Écrire le chiffre au fichier
				f_trans.write(' ');
			}
		}
		f_trans.close();
		return transposed;
	}

	private static void printGrid(int[][] grid) {			//Méthode pour afficher un fichier au format de Sudoku a l'ecran
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
				if (j == 2 || j == 5)
					System.out.print(" | ");
			}
			System.out.println();
			if (i == 2 || i == 5)
				System.out.println("_______________________");
		}
	}
}
