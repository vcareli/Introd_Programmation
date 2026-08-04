//questao 6
import java.io.*;

public class LecteurFichier {
	public static void main(String[] args) {
		try(BufferedReader file = new BufferedReader(new FileReader("notes.txt"))) {
			String l;
			while ((l = file.readLine()) != null) {
				System.out.println(l);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Erreur, lancer <EnregistreurTexte> avant : " + e.getMessage());
		} catch (IOException e)  {
			System.out.println("Erreur dans le fichier: " + e.getMessage());
		}
	}
}
