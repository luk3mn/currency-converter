package currency;

public class ExchangeCurrency {

    public ExchangeCurrency() {
    }

    public Double toDollar(String targetCurrency, Double dollar) {
        return dollar * Double.parseDouble(targetCurrency);
    }

    public Double toAnotherCurrency(String targetCurrency, Double dollar) {
        return Double.parseDouble(targetCurrency) / dollar;
    }

}
