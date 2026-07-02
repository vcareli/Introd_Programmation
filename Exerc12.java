//Exerc12
/*
 * https://lemire.github.io/inf1220-hugo/docs/environnement/?shortjavacode=34efbcbc-f398-4210-9c0f-110220bf0fa8 
*/
public class Exerc12 {
	public static void main(String[] args) {
		StringBuilder montag = new StringBuilder();
		String[][] text = new String[15][32];
		//Quebras de linha na ultima coluna do Array
		for (int l = 0; l < 15; l++) {
			text[l][31] = "\n";
		}
		//Forme du motif sur toutes les lignes
		for (int l = 0; l < 15; l++) {
			for (int c = 0; c < 31; c++) {
				if (((c - l + 32) % 4) != 3 && l%2 == 0){			//lignes paires
					text[l][c] = "#";
				}else if (((c - l + 32) % 4) == 3 && l%2 == 0) {	//lignes paires
					text[l][c] = "?";
				}else if (((c - l + 33) % 4) != 3 && l % 2 != 0) {	//Lignes impaires
					text[l][c] = "?";
				}else if (((c - l + 33) % 4) == 3 && l % 2 != 0) {	//Lignes impaires
					text[l][c] = "#";
				}
			}
		}

		//Ligne paires bord gauche
		for (int l = 0; l < 15; l++) {
			if (l%2 == 0){
				for (int c = 0; c < l; c++) {
					text[l][c] = "?";
				}
			}
		}

		////Ligne paires bord droit
		for (int l = 0; l < 15; l++) {
			if (l%2 == 0){
				for (int c = 30; c >= 31 - l; c--) {
					text[l][c] = "?";
				}
			}
		}

		//Ligne impaires bord gauche
		for (int l = 0; l < 15; l++) {
			if (l%2 != 0){
				for (int c = 0; c < l - 1; c++) {
					text[l][c] = "?";
				}
			}
		}

		//Linhas impaires lado direito
		for (int l = 0; l < 15; l++) {
			if (l%2 != 0){
				for (int c = 30; c >= 32 - l; c--) {
					text[l][c] = "?";
				}
			}
		}

		//Affecter tout le texte à une variable StringBuilder et l'afficher à l'écran.
		for (int l = 0; l < 15; l++) {
			for (int c = 0; c < 32; c++) {
				montag.append(text[l][c]);
			}
		}
		System.out.println(montag.toString());
	}
}
