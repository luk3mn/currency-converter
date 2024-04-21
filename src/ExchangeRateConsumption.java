import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateConsumption {

    public String getCurrency() {
        // HIDE KEY
        URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/08f932f826e444eb8530f0bc/latest/USD");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endpoint)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
