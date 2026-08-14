import java.util.*;

public class E2Q2 {
	public static void main(String[] args){
		int[] result = occurrences("Vinicius", 'i');
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	
	public static int[] occurrences(String s, char c) {
		int j = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c)
				count++;
		}
		int[] t = new int[count];
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				t[j] = i + 1;
				j++;
			}
		}
		return t;
	}
}
