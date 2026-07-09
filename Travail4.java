//Sudoku fichier TXT
import java.io.*;
import java.nio.*;
import java.util.HashSet;

public class Travail4 {
	public static void main(String[] args) {
		String filename = "partie4.txt";
		try {
			int[][] sudok = loadGrid(filename);
			System.out.println("Sudoku");
			printGrid(sudok);
			System.out.println();
			System.out.println("Sudoku Transposed");
			printGrid(transposeGrid(sudok));
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static int[][] loadGrid(String filename) throws IOException {
		int[][] grid = new int[9][9];
		File file = new File(filename);
		java.util.Scanner sc = new java.util.Scanner(file);
		try {
			while (sc.hasNext()) {
				String triple = sc.next();
				int l = triple.charAt(0) - '0';
				int c = triple.charAt(1) - '0';
				if ((l > 8) || (l < 0) || (c > 8) || (c < 0))
					throw new IllegalArgumentException("Le fichier Sudoku donné n'est pas valide!");
				else
					grid[l][c] = triple.charAt(2) - '0';
			}
			if (!validateGrid(grid))
				throw new IllegalArgumentException("Le fichier Sudoku donné n'est pas valide!");
		} finally {
			sc.close();
		}
		return grid;
	}

	private static boolean validateGrid(int[][] grid) {
		
		//Test des lignes
		for (int i = 0; i < grid.length; i++) {
			java.util.HashSet<Integer> blocnotes = new java.util.HashSet<>();
			for (int j = 0; j < grid.length; j++) {
				if (!blocnotes.add(grid[i][j]))
					return false;
			}
		}
		
		//Test des colonnes
		for (int j = 0; j < grid.length; j++) {
			java.util.HashSet<Integer> blocnotes = new java.util.HashSet<>();
			for (int i = 0; i < grid.length; i++) {
				if (!blocnotes.add(grid[i][j]))
					return false;
			}
		}
		
		//Test des mini matriz (3x3)
		for (int lI = 0; lI < 9; lI += 3) {
			for (int cI = 0; cI < 9; cI += 3) {
				java.util.HashSet<Integer> blocnotes = new java.util.HashSet<>();
				
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

	private static int[][] transposeGrid(int[][] grid) throws IOException {
		int[][] transposed = new int[grid.length][grid.length];
		FileWriter f_trans = new FileWriter("transpose");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				transposed[i][j] = grid[j][i];
				if (j % 3 == 0)
					f_trans.write(' ');
				f_trans.write(String.valueOf(transposed[i][j]));
			}
		}
		f_trans.close();
		return transposed;
	}

	private static void printGrid(int[][] grid) {
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
