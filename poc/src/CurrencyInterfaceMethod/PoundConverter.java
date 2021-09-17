package CurrencyInterfaceMethod;

public class PoundConverter implements ConverterInterface{
    double toCurrency;
    @Override
    public double rupees(double amount) {
        toCurrency = amount * 100;
        return toCurrency;
    }

    @Override
    public double dollar(double amount) {
        toCurrency = amount * 10 / 7.5;
        return toCurrency;
    }

    @Override
    public double euro(double amount) {
        toCurrency = amount * 10 / 9;
        return toCurrency;
    }

    @Override
    public double pound(double amount) {
        toCurrency = amount;
        return toCurrency;
    }
    public double fromPound(int currency, double amount) {
        switch (currency) {
            case 1:
                rupees(amount);
                break;
            case 2:
                dollar(amount);
                break;
            case 3:
                euro(amount);
                break;
            case 4:
                pound(amount);
                break;
            default:
                System.out.println("Error");
                break;
        }
        return toCurrency;
    }
}


