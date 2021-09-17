package CurrencyConverterInterface;

import java.util.Scanner;

public class CurrencyConverterInterface {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose 1 for Rupees, 2 for Dollar, 3 for Euro, 4 for Pound: ");
        int number = sc.nextInt();
        if(number<1 || number>4){
            System.out.println("Invalid entry");
            return;
        }
        System.out.print("How much amount you want to convert: ");
        double amount = sc.nextDouble();
        System.out.print("In which currency: ");
        int currency = sc.nextInt();
        if(currency<1 || currency>4){
            System.out.println("Invalid entry");
            return;
        }

        switch (number) {
            case 1:
                CurrencyFromRupees convertRupees = new CurrencyFromRupees();
                double fromRupees = convertRupees.currencyConverter(currency, amount);
                System.out.println(fromRupees);
                break;
            case 2:
                CurrencyFromDollar convertDollar = new CurrencyFromDollar();
                double fromDollar = convertDollar.currencyConverter(currency, amount);
                System.out.println(fromDollar);
                break;
            case 3:
                CurrencyFromEuro convertEuro = new CurrencyFromEuro();
                double fromEuro = convertEuro.currencyConverter(currency, amount);
                System.out.println(fromEuro);
                break;
            case 4:
                CurrencyFromPound convertPound = new CurrencyFromPound();
                double fromPound = convertPound.currencyConverter(currency, amount);
                System.out.println(fromPound);
                break;
            default:
                System.out.println("Exit");
                break;
        }
    }
}
