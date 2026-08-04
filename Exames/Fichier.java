//Questao 6
import java.io.*;
import java.util.*;

public class Fichier {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
			BufferedWriter file_Write = new BufferedWriter(new FileWriter("prenoms.txt"))) {
			for (int i = 1; i < 6; i++){
				System.out.print("Entrez prenom : ");
				String prenom = sc.nextLine();
				file_Write.write(prenom);
				file_Write.newLine();
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		System.out.println();
		System.out.println("----------------------------");
		try (BufferedReader file_Read = new BufferedReader(new FileReader("prenoms.txt"))) {
			String ligne;
			while ((ligne = file_Read.readLine()) != null) {
				System.out.println(ligne);
			}
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}
