public class main {
	public static void main(String[] args) {
		String frase = "Vinicius Vieira Careli";
		int qVogal = 0;
		int qConsoante = 0;
		for(char caracter : frase.toCharArray()) {
			if(caracter != ' ') {
				qConsoante++;
				if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
					qVogal++;
					qConsoante--;
				}
			}
		}
		System.out.println("Quant. de vogais: " + qVogal);
		System.out.println("Quant. de vogais: " + qConsoante);
	}
	/*public static void main(String[] args) {
		String frase = "Vinicius Vieira Careli";
		char[] letra = frase.toCharArray();
		int qVogal = 0;
		int qConsoante = 0;
		for (int i = 0; i < letra.length; i++) {
			char l = letra[i];
			if(l != ' ') {
				qConsoante++;
				if(l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
					qVogal++;
					qConsoante--;
				}
			}
		}
		System.out.println("Quant. de vogais: " + qVogal);
		System.out.println("Quant. de vogais: " + qConsoante);
	}*/
}
