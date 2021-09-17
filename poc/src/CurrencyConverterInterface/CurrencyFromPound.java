package CurrencyConverterInterface;

public class CurrencyFromPound implements Exchange {

    @Override
    public double currencyConverter(int currency, double amount) {
        double toCurrency = 0;
        switch (currency) {
            case 1:
                toCurrency = amount * 100;
                break;
            case 2:
                toCurrency = amount * 10 / 7.5;
                break;
            case 3:
                toCurrency = amount * 9 / 10;
                break;
            case 4:
                toCurrency = amount;
                break;
            default:
                System.out.println("Done!");
                break;
        }
        return toCurrency;
    }
}
