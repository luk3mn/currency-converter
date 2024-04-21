

public class Main {
    public static void main(String[] args) {

        ExchangeRateConsumption exchangeRateConsumption = new ExchangeRateConsumption();
        Currency currency = exchangeRateConsumption.getCurrency();

        System.out.println(currency);
    }
}