public class Letter {
	public static void main(String[] args) {
		String s = "A😊B";
		System.out.println(s.length());      // Affiche 4 (car 😊 occupe deux char)
		System.out.println(s.charAt(1));     // Affiche un char de la paire surrogate, pas le smiley complet
		System.out.println(s.codePointAt(1));// Affiche le code Unicode complet du smiley
	}
}
