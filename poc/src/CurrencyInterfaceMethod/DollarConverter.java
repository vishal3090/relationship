package CurrencyInterfaceMethod;

public class DollarConverter implements ConverterInterface{
        double toCurrency;
        @Override
        public double rupees(double amount) {
            toCurrency = amount * 75;
            return toCurrency;
        }

        @Override
        public double dollar(double amount) {
            toCurrency = amount;
            return toCurrency;
        }

        @Override
        public double euro(double amount) {
            toCurrency = amount * 7.5 / 9;
            return toCurrency;
        }

        @Override
        public double pound(double amount) {
            toCurrency = amount * 0.75;
            return toCurrency;
        }
    public double fromDollar(int currency, double amount) {
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
