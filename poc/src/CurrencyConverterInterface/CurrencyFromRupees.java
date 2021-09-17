package CurrencyConverterInterface;

public class CurrencyFromRupees implements Exchange{
    @Override
    public double currencyConverter(int currency, double amount) {
        double toCurrency = 0;
        switch (currency) {
            case 1:
                toCurrency = amount;
                break;
            case 2:
                toCurrency = amount / 75;
                break;
            case 3:
                toCurrency = amount / 90;
                break;
            case 4:
                toCurrency = amount / 100;
                break;
            default:
                System.out.println("Done!");
                break;
        }
        return toCurrency;
    }
}
