//Chaines abcd
public class Question2 {
	public static void main(String[] args) {
		//Variable char pour stoker les lettres
		char[] list_char = {'a', 'b', 'c', 'd'};
		//Variable pour compter les chaînes
		int mots = 0;

		//Bouble pour la 1ere lettre
		for(int i = 0; i < list_char.length; i++) {
			//Bouble pour la 2eme lettre
			for(int j = 0; j < list_char.length; j++) {
				//Bouble pour la 3eme lettre
				for(int k = 0; k < list_char.length; k++) {
					//Bouble pour la 4eme lettre
					for(int w = 0; w < list_char.length; w++) {
						//Constructeur String de lettres
						String s = Character.toString(list_char[i]) + Character.toString(list_char[j])
								+ Character.toString(list_char[k]) + Character.toString(list_char[w]);
						//Regle: 'b' toujours suivi par 'a' (Jamais un 'b' sans 'ba')
						boolean ba 			= !(s.contains("b") && !s.contains("ba"));
						//Regle: Jamais un 'a' et un 'd' dans le même chaîne
						boolean not_ad	 	= !(s.contains("a") && s.contains("d"));
						//Regle: Jamais un 'b' et un 'd' dans le même chaîne, par que 'b' est toujours suivi par 'a'
						boolean not_bd		= !(s.contains("b") && s.contains("d"));
						//Jamais finir par un 'b', par que 'b' est toujours suivi par 'a'
						boolean not_end_b	= !s.endsWith("b");
						if (ba && not_end_b && not_ad && not_bd){
							//if (s.charAt(w) == 'b')
								//if (s.charAt(w+1) == 'a'){
							System.out.println(s);
							//Compter juste les chaînes valides
							mots++;
						}
					}
				}
			}
		}

		System.out.println("Total Chaines: " + mots);
	}
}
