package CurrencyInterfaceMethod;

import java.util.Scanner;

public class CurrencyInterfaceMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose 1 for Rupees, 2 for Dollar, 3 for Euro, 4 for Pound: ");
        int number = sc.nextInt();
        if (number < 1 || number > 4) {
            System.out.println("Invalid entry");
            return;
        }
        System.out.print("How much amount you want to convert: ");
        double amount = sc.nextDouble();
        System.out.print("In which currency: ");
        int currency = sc.nextInt();
        if (currency < 1 || currency > 4) {
            System.out.println("Invalid entry");
            return;
        }
        switch (number) {
            case 1:
                RupeesConverter rupeesConverter = new RupeesConverter();
                double convertR = rupeesConverter.fromRupees(currency, amount);
                System.out.println(convertR);
                break;
            case 2:
                DollarConverter dollarConverter = new DollarConverter();
                double convertD = dollarConverter.fromDollar(currency, amount);
                System.out.println(convertD);
                break;
            case 3:
                EuroConverter euroConverter = new EuroConverter();
                double convertE = euroConverter.fromEuro(currency, amount);
                System.out.println(convertE);
                break;
            case 4:
                PoundConverter poundConverter = new PoundConverter();
                double convertP = poundConverter.fromPound(currency, amount);
                System.out.println(convertP);
                break;
            default:
                System.out.println("Exit");
                break;
        }
    }
}
