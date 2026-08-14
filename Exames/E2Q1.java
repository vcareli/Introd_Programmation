/*class Tableau {
	public static int unique(String[] t) {
		int count = 0;
		int i = 0;
		for (i = i + 1; i < t.length; i++) {
			if (t[i] == t[i - 1])
				count++;
		}
		return count;
	}
}*/

public class E2Q1 {
	public static void main(String[] args) {
		String[] pal = {"bah", "bah", "be", "bo", "bo", "bo", "bo", "ca", "ca"};
		//Tableau a = new Tableau();
		//System.out.println(unique(pal));
		System.out.println(unique(pal));
	}
	
	public static int unique(String[] t) {
		int count = 0;
		int i = 0;
		for (i = i + 1; i < t.length; i++) {
			if (t[i] == t[i - 1])
				count++;
		}
		return count;
	}
}
