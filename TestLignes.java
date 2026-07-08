import java.util.Scanner;
class TestLignes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("==> Taper deux lignes");
		System.out.print("?");
		String ligne1 = scanner.nextLine();
		System.out.print("?");
		String ligne2 = scanner.nextLine();
		System.out.println("==> Les deux lignes lues sont:\n==>  " + ligne1 + "\n==> " + ligne2);
    }
}
