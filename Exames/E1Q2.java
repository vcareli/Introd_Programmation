public class E1Q2 {
	public static void main(String[] args) {
		int[] numeros = {0,1,2,3,-4,-5,8,9,-1};
		System.out.println(entierNegatif(numeros));
	}
	
	public static int entierNegatif(int[] tab) {
		int compte = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] < 0) compte++;
		}
		return compte;
	}
}
