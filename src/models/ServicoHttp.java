package models;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoHttp {

    public String consultar(String link) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(java.net.URI.create(link))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (NumberFormatException e) {
            System.out.println("Ocorreu o seguinte erro: ");
            return e.getMessage();
        } catch (IllegalArgumentException | IOException | InterruptedException e) {
            System.out.println("Algo deu errado..");
            return e.getMessage();
        }

    }
}
