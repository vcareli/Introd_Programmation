//Transposta
public class MatrizTransposta {

	public static int[][] transposta(int[][] matriz) {
		int[][] transp = new int[matriz.length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				transp[i][j] = matriz[j][i];
			}
		}
		return transp;
	}

	public static void main(String[] args) {
		int[][] quadrada = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("Matriz quadrada correta");
		System.out.println();
		for (int i = 0; i < quadrada.length; i++) {
			for (int j = 0; j < quadrada.length; j++) {
				System.out.print(quadrada[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Matriz transposta");
		System.out.println();
		int[][] nova_q = transposta(quadrada);
		for (int i = 0; i < nova_q.length; i++) {
			for (int j = 0; j < nova_q.length; j++) {
				System.out.print(nova_q[i][j] + " ");
			}
			System.out.println();
		}
	}
}
