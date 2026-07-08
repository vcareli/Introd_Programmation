import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class BuscadorHttp {
	public static void main(String[] args) throws Exception {
		HttpClient entregador = HttpClient.newHttpClient();
		HttpRequest pedido = HttpRequest.newBuilder()
			.uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
			.GET()
			.build();
		HttpResponse<String> resposta = entregador.send(pedido, HttpResponse.BodyHandlers.ofString());
		System.out.println("Response Code: " + resposta.statusCode());
		System.out.println("Response: " + resposta.body());
	}
}
