import java.util.Scanner;
public class Voyelles {
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Saisir une phrase: ");
		String phrase = sc.nextLine();
		for (char l : phrase.toLowerCase().toCharArray()) {
			if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u' || l == 'y') {
				count++;
			}
		}
		System.out.println("Voyelles: " + count);
		sc.close();
	}
}
