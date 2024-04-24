package domainApplication;

import currency.Currency;
import currency.ExchangeCurrency;

public class UserApplication {

    private final ExchangeCurrency exchangeCurrency;
    private final Currency currency;
    private String finalResult;

    public UserApplication(ExchangeCurrency exchangeCurrency, Currency currency) {
        this.exchangeCurrency = exchangeCurrency;
        this.currency = currency;
    }

    public void showOption() {
        System.out.println("""
        ****************************************
        Welcome to exchange currency

        1) Dollar =>> Argentine Peso
        2) Argentine Peso =>> Dollar
        3) Dollar =>> Brazilian Real
        4) Brazilian Real =>> Dollar
        5) Dollar =>> Colombian Peso
        6) Colombian Peso =>> Dollar
        7) Dollar =>> Chilean Peso
        8) Chilean Peso =>> Dollar
        0) Exit

        Choose a valid option:
        *****************************************
        """);
    }

    public void chooseOption(Integer option, String exchangeValue) {
        finalResult = switch (option) {
            case 1 -> String.format(
                    "The amount %s [USD] corresponds to the final value =>>> %f [ARS]",
                    exchangeValue,
                    exchangeCurrency.dollarToAnotherCurrency(exchangeValue, currency.ARS()
                    )
            );
            case 2 -> String.format(
                    "The amount %s [ARS] corresponds to the final value =>>> %f [USD]",
                    exchangeValue,
                    exchangeCurrency.toDollar(exchangeValue, currency.ARS())
            );
            case 3 -> String.format(
                    "The amount %s [USD] corresponds to the final value =>>> %f [BRL]",
                    exchangeValue,
                    exchangeCurrency.dollarToAnotherCurrency(exchangeValue, currency.BRL())
            );
            case 4 -> String.format(
                    "The amount %s [BRL] corresponds to the final value =>>> %f [USD]",
                    exchangeValue,
                    exchangeCurrency.toDollar(exchangeValue, currency.BRL())
            );
            case 5 -> String.format(
                    "The amount %s [USD] corresponds to the final value =>>> %f [COP]",
                    exchangeValue,
                    exchangeCurrency.dollarToAnotherCurrency(exchangeValue, currency.COP())
            );
            case 6 -> String.format(
                    "The amount %s [COP] corresponds to the final value =>>> %f [USD]",
                    exchangeValue,
                    exchangeCurrency.toDollar(exchangeValue, currency.COP())
            );
            case 7 -> String.format(
                    "The amount %s [USD] corresponds to the final value =>>> %f [CLP]",
                    exchangeValue,
                    exchangeCurrency.dollarToAnotherCurrency(exchangeValue, currency.CLP())
            );
            case 8 -> String.format(
                    "The amount %s [CLP] corresponds to the final value =>>> %f [USD]",
                    exchangeValue,
                    exchangeCurrency.toDollar(exchangeValue, currency.CLP())
            );
            default -> finalResult;
        };
    }

    public String getFinalResult() {
        return finalResult;
    }
}
