package exchangeRate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import currency.Currency;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateConsumption {

    public Currency getCurrency() {
        URI endpoint = URI.create("https://v6.exchangerate-api.com/v6/08f932f826e444eb8530f0bc/latest/USD");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endpoint)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            String currency = String.valueOf(jsonObject.get("conversion_rates"));
            return new Gson().fromJson(currency, Currency.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
