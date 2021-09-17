package CurrencyConverter;
public class ConvertFromPound1 {
    double rupees, dollar, euro, pound;
    public void ConvertFromPoundCurrency1(int currency, double amount){
        switch (currency) {
            case 1:
                rupees = amount * 100;
                System.out.println(rupees + " Rupees");
                break;
            case 2:
                dollar = amount * 10 / 7.5;
                System.out.println(dollar + " Dollar");
                break;
            case 3:
                euro = amount * 9 / 10;
                System.out.println(euro + " Euro");
                break;
            case 4:
                System.out.println(pound + " Pound");
                break;
            default:
                System.out.println("Done!");
                break;
        }
    }
}
