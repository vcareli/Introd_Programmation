import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Binary {
	public static void main(String[] args) throws IOException {
		//Variaveis dos arquivos
		String raizsegura = System.getProperty("user.home");
		String diretorio = "monRepertoire";
		Path dir = Path.of(raizsegura, diretorio, "monFichier");
		Files.createDirectories(dir.getParent());

		//Gravando file binario
		System.out.println("Escrever binario: 0 - 4");
		try(DataOutputStream w_arq = new DataOutputStream(new FileOutputStream(dir.toString()))) {
			for (int i = 0; i < 5; i++) {
				w_arq.writeInt(i);
			}
		} catch (IOException e) {
			System.out.println("Erro ao gravar: " + e.getMessage());
		}

		//Lendo file binario
		System.out.println("Leitura binario");
		try (DataInputStream r_arq = new DataInputStream(new FileInputStream(dir.toString()))) {
			for (int i = 0; i < 5; i++) {
				int num = r_arq.readInt();
				System.out.println("Numero: " + num);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler: " + e.getMessage());
		}

		//Gravando file binario - modo append
		System.out.println("Append - Adicionando informaçoes binario");
		try(DataOutputStream w_arq = new DataOutputStream(new FileOutputStream(dir.toString(), true))) {
			for (int i = 6; i < 10; i++) {
				w_arq.writeInt(i);
			}
		} catch (IOException e) {
			System.out.println("Erro ao gravar: " + e.getMessage());
		}

		//Lendo file binario
		System.out.println("Leitura binario");
		try (DataInputStream r_arq = new DataInputStream(new FileInputStream(dir.toString()))) {
			System.out.print("Numeros: ");
			while (true) {
				int num = r_arq.readInt();
				System.out.print(num + " ");
			}
		} catch (EOFException f) {
			System.out.println();
			System.out.println("--- Fim do arquivo ---");
		} catch (IOException e) {
			System.out.println("Erro ao ler: " + e.getMessage());
		}
	}
}