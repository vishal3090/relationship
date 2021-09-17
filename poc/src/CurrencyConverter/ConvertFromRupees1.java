package CurrencyConverter;

class ConvertFromRupees1{
    double rupees, dollar, euro, pound;
    public void ConvertFromRupeesCurrency1(int currency, double amount){
        switch (currency) {
            case 1:
                rupees = amount;
                System.out.println(amount + "Rupees");
                break;
            case 2:
                dollar = amount / 75;
                System.out.println(dollar + " Dollar");
                break;
            case 3:
                euro = amount / 90;
                System.out.println(euro + " Euro");
                break;
            case 4:
                pound = amount / 100;
                System.out.println(pound + " Pound");
                break;
            default:
                System.out.println("Done!");
                break;
        }
    }
}
