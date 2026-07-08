//String Write and Read
import java.io.*;

public class StringWriteRead {
	public static void main(String[] args) throws IOException {
		StringWriter tb = new StringWriter();
		PrintWriter escritor = new PrintWriter(tb);
		escritor.println("Nome=Pedro");
		escritor.println("Idade=25");
		escritor.println("Nome=Maria");
		escritor.println("Idade=20");
		StringReader show = new StringReader(tb.toString());
		BufferedReader leitor = new BufferedReader(show);
		String sacola;
		while ((sacola = leitor.readLine()) != null) {
			System.out.println(sacola);
		}
	}
}
