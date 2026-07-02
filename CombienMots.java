/* Q23
Vous avez à créer une classe qui selon une constante de type nombre
entier présente dans la classe, le code doit afficher le bon nombre de
mots de la phrase suivante : "Veni vidi vici". Vous ne pouvez
qu'utiliser les opérateurs vus dans la leçon précédente (truc: opérateur
à trois opérandes).
*/

public class CombienMots{
	public static int mot = 0;
	
	public static void main(String[] args){
		String phrase = "Veni vidi vici";
		int count = 0;
		for (int i = 0; i < phrase.length(); i++){
			if (phrase.charAt(i) == ' '){
					count++;
			}
		}
		System.out.println("N. de palavras: " + (count + 1));
	}
}

/*public class CombienMots {
    
        // La constante qui détermine le nombre de mot;
        public static final int nombreDeMot = 3;
        
        public static final String veni = "Veni";
        public static final String vidi = "vidi";
        public static final String vici = "vici";
        
        public static void main(String[] args){
            
                String phrase = new String();
            
                phrase = (nombreDeMot == 3) ? veni + vidi + vici : (nombreDeMot == 2) ? veni + vidi : (nombreDeMot == 1) ? veni : "";
                
                System.out.println("Phrase : " + phrase);
        }                        
    
}
*/
