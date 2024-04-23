import currency.Currency;
import currency.ExchangeCurrency;
import domainApplication.UserApplication;
import exchangeRate.ExchangeRateConsumption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExchangeRateConsumption exchangeRateConsumption = new ExchangeRateConsumption();
        Currency currency = exchangeRateConsumption.getCurrency();
        ExchangeCurrency exchangeCurrency = new ExchangeCurrency();


        UserApplication userApplication = new UserApplication(exchangeCurrency, currency);
        Scanner scannerOption = new Scanner(System.in);
        Scanner scannerValue = new Scanner(System.in);

        while(true) {

            userApplication.showOption();
            Integer option = scannerOption.nextInt();

            if (option.equals(7)) {
                System.out.println("Exit ..........");
                break;
            } else if (option > 7) {
                System.out.println("""
                
                ************************************
                *** This option is not available ***
                ************************************
                
                """);
            } else {
                System.out.println("Place the value you want to convert: ");
                String exchangeValue = scannerValue.nextLine();
                userApplication.chooseOption(option, exchangeValue);

                System.out.println(userApplication.getFinalResult());
            }

        }
    }
}