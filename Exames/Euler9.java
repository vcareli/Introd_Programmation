public class Euler9 {
	public static boolean pitagoras(int a, int b, int c) {
		return a < b && b < c && (a*a + b*b == c*c);
	}
	
	public static void main(String[] args) {
		//System.out.print(pitagoras(3, 4, 5));
		for (int a = 1; a < 500; a++) {
			for (int b = a + 1; b < 500; b++) {
				int c = 1000 - a - b;
				if (pitagoras(a, b, c)) {
					System.out.println(a + " - " + b + " - " + c);
					System.out.println("a * b * c = " + (a * b * c));
				}
			}
		}
	}
}
