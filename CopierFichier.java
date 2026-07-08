import java.io.*;

public class CopierFichier {
	public static void main(String[] args) {
		int 				octete;
		FileInputStream     file_from;
		FileOutputStream    file_cpy;		

		try{
			file_from = new FileInputStream("octete.txt");
			file_cpy = new FileOutputStream("copie_octete.txt");
			while ((octete = file_from.read()) != -1) file_cpy.write(octete);
			file_from.close();
			file_cpy.close();
			System.out.println("Fichier octete.txt copié vers copie_octete.txt avec succes!");
		} catch (IOException e) {
			System.out.println("Exception\n" + e.toString());
			System.out.println("*Fichier non trouvé!");
		}
	}
}
