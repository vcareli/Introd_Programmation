//questao 5
import java.util.Scanner;
import java.io.*;

public class EnregistreurTexte {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
		BufferedWriter file = new BufferedWriter(new FileWriter("notes.txt"))) {
			System.out.println("Entrez 3 phrases : ");
			for (int i = 0; i < 3; i++) {
				String t = sc.nextLine();
				file.write(t);
				file.newLine();
			}
		} catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}
