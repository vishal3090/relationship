package Phonebook;

import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBookImpl phoneBook = new PhoneBookImpl();
        System.out.println("Enter number for your choice \n1 for add new contact \n2 for show all contacts \n3 for sort by name \n4 for remove contact \n5 for search name or number \n6 for Exit");

        int i = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice");
            int index = sc.nextInt();

            switch (index) {
                case 1:
                    phoneBook.addContact();
                    break;
                case 2:
                    System.out.println("Phonebook list");
                    phoneBook.print();
                    break;
                case 3:
                    System.out.println("Sort by name");
                    phoneBook.sortContact();
                    break;
                case 4:
                    System.out.println("Remove contact");
                    System.out.println("Enter number which you want to remove");
                    Long del = sc.nextLong();
                    phoneBook.deleteContact(del);
                    break;
                case 5:
                    System.out.println("Search name or number");
                    phoneBook.searchContact();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Exit");
            }
            i++;
        } while (i < 100);
    }
}