//q 6
public class Euler6 {
	public static void main(String[] args) {
		int diff = quads(100) - somaq(100);
		System.out.println(diff);
	}
    
	public static int somaq(int n) {
		int sq = 0;
		for (int i = 1; i <= n; i++){
			sq += (i * i);
		}
		return sq;
	}
    
	public static int quads(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++){
			sum += i;
		}
	return sum * sum;
	}
}
