import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExchangeRateConsumption exchangeRateConsumption = new ExchangeRateConsumption();
        Currency currency = exchangeRateConsumption.getCurrency();


        ExchangeCurrency exchangeCurrency = new ExchangeCurrency();
        Scanner scannerOption = new Scanner(System.in);
        Scanner scannerValue = new Scanner(System.in);

        String option = "";
        String finalResult = "";
        while(true) {

            System.out.println("""
            ****************************************
            Welcome to exchange currency

            1) Dollar =>> Argentine Peso
            2) Argentine Peso =>> Dollar
            3) Dollar =>> Brazilian Real
            4) Brazilian Real =>> Dollar
            5) Dollar =>> Colombian Peso
            6) Colombian Peso =>> Dollar
            7) Exit

            Choose a valid option:
            *****************************************
            """);

            option = scannerOption.nextLine();

            if (option.equals("7")) {
                System.out.println("Exit ..........");
                break;
            }

            System.out.println("Place the value you want to convert: ");
            String exchangeValue = scannerValue.nextLine();

            finalResult = switch (option) {
                case "1" -> String.format(
                        "The amount %s [USD] corresponds to the final value =>>> %f [ARS]",
                        exchangeValue,
                        exchangeCurrency.toAnotherCurrency(exchangeValue, currency.ARS()
                        )
                );
                case "2" -> String.format(
                        "The amount %s [ARS] corresponds to the final value =>>> %f [USD]",
                        exchangeValue,
                        exchangeCurrency.toDollar(exchangeValue, currency.ARS())
                );
                case "3" -> String.format(
                        "The amount %s [USD] corresponds to the final value =>>> %f [BRL]",
                        exchangeValue,
                        exchangeCurrency.toAnotherCurrency(exchangeValue, currency.BRL())
                );
                case "4" -> String.format(
                        "The amount %s [BRL] corresponds to the final value =>>> %f [USD]",
                        exchangeValue,
                        exchangeCurrency.toDollar(exchangeValue, currency.BRL())
                );
                case "5" -> String.format(
                        "The amount %s [USD] corresponds to the final value =>>> %f [COP]",
                        exchangeValue,
                        exchangeCurrency.toAnotherCurrency(exchangeValue, currency.COP())
                );
                case "6" -> String.format(
                        "The amount %s [COP] corresponds to the final value =>>> %f [USD]",
                        exchangeValue,
                        exchangeCurrency.toDollar(exchangeValue, currency.COP())
                );
                default -> finalResult;
            };

            System.out.println(finalResult);
        }
    }
}