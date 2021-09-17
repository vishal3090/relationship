package CurrencyConverterInterface;

public class CurrencyFromEuro implements Exchange {
    public double currencyConverter(int currency, double amount) {
        double toCurrency = 0;
        switch (currency) {
            case 1:
                toCurrency = amount * 90;
                break;
            case 2:
                toCurrency = amount * 9 / 7.5;
                break;
            case 3:
                toCurrency = amount;
                break;
            case 4:
                toCurrency = amount * 10 / 9;
                break;
            default:
                System.out.println("Done!");
                break;
        }
        return toCurrency;
    }
}
