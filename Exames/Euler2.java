//q2
public class Euler2 {
	public static void main(String[] args) {
		int t1 = 1;
		int t2 = 2;
		int tp = 0;
		int sum = 2;
		//System.out.print("Seq. Fibonacci : ");
		//System.out.print(tp + ", " + t1 + ", " + t2 + ", ");
		while (tp <= 4000000) {
			tp = t1 + t2;
			t1 = t2;
			t2 = tp;
			if ( tp < 4000000) {
				if (tp % 2 == 0) sum += tp;
				//System.out.print(tp + " ");
			}
		}
		//System.out.println();
		//System.out.println();
		System.out.println("Somme pairs : " + sum);
		System.out.println();
	}
}
