public class E2Q5 {
	public static void main(String[] args) {
		Fruits manga = new Fruits();
		Fruits raisin = new Fruits();
		System.out.println("Manga : " + manga.mange());
		System.out.println("Manga : " + manga.mange());
		System.out.println("Manga : " + manga.mange());
		System.out.println("Manga : " + manga.jette());
		System.out.println("Manga : " + manga.jette());
		System.out.println("Uva : " + raisin.jette());
		System.out.println("Uva : " + raisin.jette());
		System.out.println("Uva : " + raisin.jette());
		System.out.println("Uva : " + raisin.mange());
	}
}

class Fruits {
	private static int compte_class = 0;
	private int compte_instance = 0;
	public int jette() {
		return ++compte_class;
	}
	
	public int mange() {
		return ++compte_instance;
	}
}
