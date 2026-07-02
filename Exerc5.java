/*exerc 5*/
import javax.swing.JOptionPane;

public class Exerc5{
	public static void main(String args[]){
		int h_Alice = 104;
		int h_Bob = 80;
		int h_Chuck = 76;
		int h_Danielle = 110;
		int h_Eloi = 102;
		int moyenne;
		
		//Calcule de la moyenne (int)
		moyenne = (h_Alice + h_Bob + h_Chuck + h_Danielle + h_Eloi)/5;
		
		//Afficher par JOptionPane
		JOptionPane.showMessageDialog(null,"La moyenne est: " + moyenne);
		
		//Afficher par println
		System.out.println("Moyenne..: " + moyenne);
		System.out.println("Alice....: " + h_Alice + " - Ecart: " + (h_Alice - moyenne));
		System.out.println("Bob......: " + h_Bob + " - Ecart: " + (h_Bob - moyenne));
		System.out.println("Chuck....: " + h_Chuck + " - Ecart: " + (h_Chuck - moyenne));
		System.out.println("Danielle.: " + h_Danielle + " - Ecart: " + (h_Danielle - moyenne));
		System.out.println("Eloi.....: " + h_Eloi + " - Ecart: " + (h_Eloi - moyenne));
		//System.out.println("Eloi.....: " + h_Eloi + " - Ecart: " + Math.abs(h_Eloi - moyenne));
	}
}
