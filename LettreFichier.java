//Compteur de lettre dans un fichier TXT
import java.io.*;

public class LettreFichier{
	public static void main(String[] args){
		int octete;
		int i = 0;
		FileInputStream arq;

		try{
			arq = new FileInputStream("octete.txt");
			while ((octete = arq.read()) != -1){
				if (Character.toUpperCase((char) octete) == 'E')
					i++;
			}
			arq.close();
			System.out.println("Nombre lettres << a >> : " + i);
		} catch (IOException e) {
			System.out.println("Exceptio\n" + e.toString());
			System.out.println("* Fichier non trouvé!");
		}
	}
}
