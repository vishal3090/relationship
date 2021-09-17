package CurrencyConverter;
class ConvertFromDollar1 {
    double rupees, dollar, euro, pound;
    public void ConvertFromDollarCurrency1(int currency, double amount){
        switch (currency) {
            case 1:
                rupees = amount * 75;
                System.out.println(rupees + " Rupees");
                break;
            case 2:
                System.out.println(dollar + " Dollar");
                break;
            case 3:
                euro = amount * 7.5 / 9;
                System.out.println(euro + " Euro");
                break;
            case 4:
                pound = amount * 0.75;
                System.out.println(pound + " Pound");
                break;
            default:
                System.out.println("Done!");
                break;
        }
    }
}
