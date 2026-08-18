public class Euler5 {
	public static void main(String[] args){
		int n = 20;
		int d = 1;
		while (d != 20){
			while (n % d == 0){
				if (d == 20)
					break;
				d++;
			}
			if (d != 20) {
				d = 1;
				n += 20;
			}
		}
		System.out.println(n);
	}
}
