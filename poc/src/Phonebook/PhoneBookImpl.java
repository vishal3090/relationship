package Phonebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class PhoneBookImpl {

    ArrayList<Person> list = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void addContact() {
        System.out.println("Add new contact");
        System.out.println("Add name");
        String name = sc.next();
        System.out.println("Add phone number");
        Long number = sc.nextLong();
        Person obj = new Person(name, number);

        boolean isPersonExist = false;
        for (Person display : list) {
            if (display.number.equals(obj.number)) {
                isPersonExist = true;
                System.out.println("Entry already exist");
                break;
            }
        }
        if (!isPersonExist) {
            list.add(obj);
        }

    }

    public void print() {
        for (Person display : list) {
            System.out.println("Name : " + display.name + ", Number : " + display.number);
        }
    }

    public void sortContact() {

        list.sort(Comparator.comparing(Person::getName));
        for (Person display : list) {
            System.out.println("Name : " + display.name + ", Number : " + display.number);
        }
    }

    public void deleteContact(Long del) {
        for (int i = 0; i < list.size(); i++) {
            Person index = list.get(i);
            if (index.number.equals(del)) {
                list.remove(index);
                System.out.println("Removed");
            }
        }
    }

    public void searchContact() {
        System.out.println("Enter 1 for name search \nEnter 2 for number search");
        int searchOption = sc.nextInt();
        switch (searchOption) {
            case 1:
                System.out.println("Enter name");
                String searchName = sc.next();
                for (Person index : list) {
                    if (index.name.equals(searchName)) {
                        System.out.println("Name : " + index.name + ", Number : " + index.number);
                    }
                }
                break;
            case 2:
                System.out.println("Enter number");
                Long searchNumber = sc.nextLong();
                for (Person index : list) {
                    if (index.number.equals(searchNumber)) {
                        System.out.println("Name : " + index.name + ", Number : " + index.number);
                    }
                }
                /*
                for(int i =0; i<list.size(); i++){
                    Person index = list.get(i);
                    if(index.name.equals(searchOption)){
                        boolean search = list.contains(searchOption);
                        System.out.println(search);
                        System.out.println(index.name+" "+index.number);
                    }
                }*/
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}