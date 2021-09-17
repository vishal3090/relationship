package CurrencyConverter;
public class ConvertFromEuro1 {
    double rupees, dollar, euro, pound;
    public void ConvertFromEuroCurrency1(int currency, double amount){
        switch (currency) {
            case 1:
                rupees = amount * 90;
                System.out.println(rupees+" Rupees");
            case 2:
                dollar = amount * 9 / 7.5;
                System.out.println(dollar+" Dollar");
                break;
            case 3:
                System.out.println(euro+" Euro");
                break;
            case 4:
                pound = amount * 10 / 9;
                System.out.println(pound+" Pound");
                break;
            default:
                System.out.println("Done!");
        }
    }
}
