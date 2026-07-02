public class Textos {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("Ola");
		System.out.println("tamanho: " + s.length());
		System.out.println(s);
		s.append(" mundo!");
		System.out.println("tamanho: " + s.length());
		System.out.println(s);
		s.insert(3, ",");
		System.out.println("tamanho: " + s.length());
		System.out.println(s);
		s.replace(5, 12, "Universo");
		System.out.println("tamanho: " + s.length());
		System.out.println(s);
		s.reverse();
		System.out.println(s);
		s.reverse();
		System.out.println(s);
	}
}
