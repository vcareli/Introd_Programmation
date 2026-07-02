import java.util.*;

class Lista {
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		
		System.out.println(lista.isEmpty());
		lista.add("Vinny");
		System.out.println(lista.get(0));
		lista.set(0, "Deby");
		System.out.println(lista.get(0));
		System.out.println(lista.isEmpty());
	}
}
