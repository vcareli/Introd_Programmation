public class Somme1a10000 {
	public static void main(String[] args) {
		/*
		 * La méthode main doit être créée avec les modificateurs suivants
		 * public : permet à la classe d'accéder à la méthode main
		 * static: ne permet pas les modifications et oblige Java à l'exécuter avant toutes les autres méthodes
		**/
		int somme = 0;
		
		for (int i = 1; i <= 10000; i++) {
			//if pour supprimer les numeros divisibles par 3 (i%3 != 0)
			//et aussi les numeros 2 ou 3 dans les centaines
			//(i/100)%2 -> permet de visualiser les chiffres de centaines.			
			if ((i % 3 != 0) && ((i/100)%10 != 2) && ((i/100)%10 != 3)) {
				somme += i;
			}
		}
		System.out.println("Somme des nombres de 1 à 10 000 :");
		System.out.println("à l'exclusion des nombres divisibles par 3 et");
		System.out.println("des nombres dont le chiffre des centaines est 2 ou 3");
		System.out.println("Somme est: " + somme);
	}
}