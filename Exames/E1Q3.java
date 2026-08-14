import java.io.*;
import java.util.*;

public class E1Q3 {
	public static void main(String[] args) {
		Fichier f1 = new Fichier("casa.txt");
		f1.enregistre("maison.txt");
		Fichier f2 = new Fichier("maison.txt");
		if (f1.getChaine().equals(f2.getChaine())) {
			System.out.println("f1 : " + f1.getChaine());
			System.out.println("f2 : " + f2.getChaine());
		}
	}
}

class Fichier {
	private String file;
	private List<String> chaine = new ArrayList<String>();

	public Fichier(String file) {
		this.file = file;
		try (BufferedReader f = new BufferedReader(new FileReader(file))) {
			boolean v = true;
			String ligne;
			while (v) {
				ligne = f.readLine();
				if (ligne != null)
					chaine.add(ligne);
				else
					v = false;
			}
		} catch (FileNotFoundException e) {
			System.out.print("Fichier non trouvé. " + e.getMessage());
		} catch (IOException e) {
			System.out.print("Erreur : " + e.getMessage());
		}
	}
	
	public void enregistre(String file) {
		try (BufferedWriter f = new BufferedWriter(new FileWriter(file))) {
			for (String ligne : chaine) {
				f.write(ligne);
				f.newLine();
			}
		} catch (IOException e) {
			System.out.print("Erreur : " + e.getMessage());
		}
	}
	
	public List<String> getChaine() {
		return chaine;
	}
}
