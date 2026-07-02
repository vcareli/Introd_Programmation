//Exerc17 char
import java.util.Scanner;

public class Unicode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite qualquer caracter ou texto: ");
		String texto = sc.nextLine();
		
		for(char o : texto.toCharArray()) {
			System.out.println("O UNICODE de " + o + " vale: " + (int) o);
		}
		
	}
}
