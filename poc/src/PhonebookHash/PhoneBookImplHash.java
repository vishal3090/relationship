package PhonebookHash;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBookImplHash {
    HashMap<Long, String> contactMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void addContact() {
        System.out.println("Add new contact");
        System.out.println("Add name");
        String name = sc.next();
        System.out.println("Add phone number");
        Long number = sc.nextLong();
        contactMap.put(number, name);
    }

    public void print() {
        contactMap.forEach((key, value) -> System.out.println("ContactNo. = " + key + ", Name = " + value));
    }

    public void sortContact() {
        LinkedHashMap<Long, String> collect = contactMap.entrySet().stream()
                .sorted((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));

        for (Map.Entry<Long, String> display : collect.entrySet()) {
            System.out.println("ContactNo. = " + display.getKey() + ", Name = " + display.getValue());
        }
    }

    public void deleteContact(Long del) {

        Iterator<Map.Entry<Long, String>> iterator = contactMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, String> entry = iterator.next();
            if (del.equals(entry.getKey())) {
                iterator.remove();
                System.out.println("Successfully Removed");
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
                for (Map.Entry<Long, String> display : contactMap.entrySet()) {
                    if (display.getValue().equals(searchName)) {
                        System.out.println("Name: " + display.getValue() + ", Number: " + display.getKey());
                    }
                }
                break;
            case 2:
                System.out.println("Enter number");
                Long searchNumber = sc.nextLong();
                if (contactMap.containsKey(searchNumber)) {
                    System.out.println("Name: " + contactMap.get(searchNumber) + ", Number: " + searchNumber);
                }
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}
