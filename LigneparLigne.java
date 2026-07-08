//Le arquivo e mostra linha por linha
import java.util.*;
import java.io.*;

public class LigneparLigne {
	public static void main(String[] args) {
		File arq = new File("octete.txt");
		int i = 1;
		try(BufferedReader file = new BufferedReader(new FileReader(arq))) {
			String ligne;
			while ((ligne = file.readLine()) != null) {
				System.out.println(i + ": " + ligne);
				i++;
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
