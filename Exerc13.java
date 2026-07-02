//Exerc13
public class Exerc13 {
	public static void main(String[] args) {
		String text = "124213";
		String[] chiffres = text.split("");
		Integer num;
		for (String c : chiffres) {
			num = Integer.parseInt(c);
			System.out.println(num);
		}
	}
}
