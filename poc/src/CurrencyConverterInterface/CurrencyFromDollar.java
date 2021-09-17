package CurrencyConverterInterface;

public class CurrencyFromDollar implements Exchange{
    public double currencyConverter(int currency, double amount) {
        double toCurrency = 0;
        switch (currency) {
            case 1:
                toCurrency = amount * 75;
                break;
            case 2:
                toCurrency = amount;
                break;
            case 3:
                toCurrency = amount * 7.5 / 9;
                break;
            case 4:
                toCurrency = amount * 0.75;
                break;
            default:
                System.out.println("Done!");
                break;
        }
        return toCurrency;
    }
}
