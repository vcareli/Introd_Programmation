//Compte les characteres d'un fichier txt
import java.io.*;
import java.util.Scanner;

public class CompterChar {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nom du fichier: ");
		String file = sc.nextLine();
		File arq = new File(file);
		int i = 0;
		if (!arq.exists()){
			System.out.println("Fichier non trouvé.");
			System.exit(0);
		} else {
			FileReader r_arq = new FileReader(arq);
			while (r_arq.read() != -1) i++;
			r_arq.close();
		}
		System.out.println("Total de caracteres: " + i);
	}
}
