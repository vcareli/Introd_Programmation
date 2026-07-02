import java.util.Random;

public class GeraSenha {
	public static void main(String[] args) {
		/*Random senha_num = new Random();
		int numero = senha_num.nextInt(999999) + 1;
		System.out.println("Gerador Senha numerica: " + numero);*/
		Random random = new Random();
		String c = "ABCDEFHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz0123456789!?*@";
		int longueur = 8;
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < longueur; i++) {
			int index = random.nextInt(c.length());
			senha.append(c.charAt(index));
		}
		System.out.println("Gerador Senha alfa-numerica: " + senha.toString());
	}
}
