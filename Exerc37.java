/*exerc37*/

public class Exerc37{
	public static void main(String arg[]){
		//int a = 2147483647;
		//int b = 2147483646;
		int a = 6;
		int b = 4;
		int m1 = (a + b) / 2;	//Methode traditional
		int m2 = a + (b - a) / 2;	//Methode pour grands numeros
		System.out.println(m1);
		System.out.println(m2);
	}
}
