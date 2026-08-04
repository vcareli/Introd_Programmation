//questao1
import java.io.*;
import java.util.*;

public class Examen1 {
	public static void main(String[] args) {
		try (BufferedReader file = new BufferedReader(new FileReader("notes.txt"))) {
			Deque<String> pile = new ArrayDeque<String>();
			String ligne;
			while ((ligne = file.readLine()) != null) {
				pile.push(ligne);
			}
			while (!pile.isEmpty()) {
				System.out.println(pile.pop());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichier " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error du fichier : " + e.getMessage());
		}
	}
}
