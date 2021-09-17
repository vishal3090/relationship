package CurrencyConverter;

import java.util.Scanner;

public class CurrencyConverterPackage {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose 1 for Rupees, 2 for Dollar, 3 for Pound, 4 for Euro: ");
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
            ConvertFromRupees1 convertRupees = new ConvertFromRupees1();
            ConvertFromDollar1 convertDollar = new ConvertFromDollar1();
            ConvertFromEuro1 convertEuro = new ConvertFromEuro1();
            ConvertFromPound1 convertPound = new ConvertFromPound1();
            switch (number) {
                case 1:
                    convertRupees.ConvertFromRupeesCurrency1(currency, amount);
                    break;
                case 2:
                    convertDollar.ConvertFromDollarCurrency1(currency, amount);
                    break;
                case 3:
                    convertEuro.ConvertFromEuroCurrency1(currency, amount);
                    break;
                case 4:
                    convertPound.ConvertFromPoundCurrency1(currency, amount);
                    break;
                default:
                    System.out.println("Done!");
                    break;
            }

        }
    }
