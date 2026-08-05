public class E1Q1 {
	public static void main(String[] args) {
		System.out.println(InverserChaine("socorrammesubinoonibusemmarrocos"));
	}
	
	public static String InverserChaine(String chaine) {
		String inverse = new StringBuilder(chaine).reverse().toString();
		return inverse;
	}
}
