import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tempo {
	private static String extractArray(String json, String key) {
		int start = json.indexOf(key) + key.length();
		int end = json.indexOf("]", start) + 1;
		return json.substring(start, end);
	}
	
	public static void main(String[] args) {
		//Coloque as coordenadas da cidade que vc deseja.... (Quebec City)
		double latitude = 46.829853;
		double longitude = -71.254028;
		String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
		 "&longitude=" + longitude + "&hourly=temperature_2m,precipitation";
		
		try {
			
			//Criando cliente http
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			
			//Extrai os horarios
			String horario = json.substring(json.indexOf("\"hourly\":{"));
			String hora = extractArray(horario, "\"time\":");
			String temp = extractArray(horario, "\"temperature_2m\":");
			String chuva = extractArray(horario, "\"precipitation\":");
			
			//Formato Data/Hora
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			
			//Previsao para 12horas
			System.out.println();
			System.out.println("Previsao para Quebec City (prox. 12 heures): ");
			LocalDateTime now = LocalDateTime.now();
			String[] timeArray = hora.split(",");
			String[] tempArray = temp.split(",");
			String[] precipArray = chuva.split(",");
			int count = 0;
			for (int i = 0; i < timeArray.length && count < 12; i++) {
				String horas = timeArray[i].replace("[\"","").replace("\"]","").replace("\"","");
                LocalDateTime forecastTime = LocalDateTime.parse(horas, formatter);
                if (forecastTime.isAfter(now)) {
                    double tempr = Double.parseDouble(tempArray[i].replace("[","").replace("]",""));
                    double precip = Double.parseDouble(precipArray[i].replace("[","").replace("]",""));
                    System.out.printf("%s : %.1f°C, Précipitations : %.1f mm%n",
                            forecastTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                            tempr, precip);
                    count++;
				}
			}
		} catch(Exception e) {
			System.err.println("Erreur lors de la récupération des données : " + e.getMessage());;
		}
		System.out.println();
	}
}
