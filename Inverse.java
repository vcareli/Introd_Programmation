//String Invertida
import java.lang.*;

public class Inverse {
	public static void main(String[] args) {
		StringBuilder voyelles = new StringBuilder("aeiou");
		for (char v: voyelles.reverse().toString().toCharArray()) {
			System.out.print(v);
		}
	}
}
