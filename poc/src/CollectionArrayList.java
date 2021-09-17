import Phonebook.Person;

import java.util.*;
public class CollectionArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>(5);
        l2.add(15);
        l2.add(17);
        l2.add(18);
        l1.add(6);
        l1.add(7);
        l1.add(4);
        l1.add(9);
        l1.add(6);
        l1.add(1);

        //Iterator add which we want between elements in this list
        /*Iterator<Integer> iter = l1.iterator();
        System.out.println("The iteraror values of l1 are: ");
        while (iter.hasNext()){
            System.out.print("Value is : " + iter.next());
        }

        //Iteratorlist
        ListIterator<Integer> iterator = l1.listIterator();
        System.out.println("Using listIterator forward direction");
        while (iterator.hasNext()){
            System.out.println("Value is : " + iterator.next());
        }
        System.out.println("Using listIterator forwbackwardard direction");
        while (iterator.hasPrevious()){
            System.out.println("Value is : " + iterator.previous());
        }

        //System.out.println(l1.indexOf(6));
        //System.out.println(l1.lastIndexOf(6));

        //System.out.println(l1);//display array
        //System.out.println(l1.size());//display size of array
        //display l1 and l2 array

        //l1.clear(); //Clear array list
        //Clone
        /*ArrayList l1Clone = new ArrayList();
        l1Clone = (ArrayList) l1.clone();
        System.out.println(l1Clone);*/

        //remove and removeall
        //l1.remove(1);//remove specified index number element
        //l1.removeAll(l1);//remove all element
        //System.out.println(l1);
        //removeIf : removes all elements from the array list that satisfy the condition
        /*l1.removeIf(integer -> (integer%2) == 0);
        System.out.println("Odd numbers " + l1);*/

        //Add another loop
        //l1.addAll(0,l2);
        //System.out.println(l1);

        //System.out.println(l1.contains(6));//if array contains number then it display true else false

        //get(index) returns the element at the specified position in this list
        //System.out.println(l1.get(3));

        //Returns true if this list contains no elements
        //System.out.println(l1.isEmpty());


        //l1.set(2, 44);//Replace the element
        //size() return the number of elements in this list
        /*for (int i=0; i<l1.size(); i++){
            System.out.print(l1.get(i));
            System.out.print(", ");
        }*/

        //Replaceall
        /*ArrayList<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("javascript");
        languages.add("jquery");
        languages.add("angularjs");
        languages.trimToSize();//Trims the capacity of this ArrayList instance to be the list's current size
        System.out.println(languages);
        languages.replaceAll(e -> e.toUpperCase());{
            System.out.println("Updated arraylist:" +languages);
        }
        List<String> languages1 = languages.subList(1,3);
        System.out.println(languages1);*/

        Scanner reader = new Scanner(System.in);
        ArrayList<String> memory = new ArrayList<String>();

        while (true) {
            memory.add(reader.nextLine());
            System.out.println(memory.toString());
        }

    }

    /*public void addContact() {
        System.out.println("Add new contact");
        System.out.println("Add name");
        String name = sc.next();
        System.out.println("Add phone number");
        long number = sc.nextLong();
        Person obj = new Person(name, number);
    }*/
    /*public void sorting(ArrayList<Person> list){
        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        sorting(list);

    }*/
/*
class NameSorter implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
/*list.sort(new NameSorter());
        for (Person display : list) {
            System.out.println("Name : " + display.name + ", Number : " + display.number);
        }*/
}
/*System.out.println("Enter Name");
        String searchName = sc.next();
        if(list.containsValue(searchName))
        {
            System.out.print("Name = "+searchName+" Number = ");
            System.out.println(list.get(searchName));
        }else {
            System.out.println("Not found");
        }*/

    /*public void print() {

        for (Map.Entry display : list.entrySet()) {
            System.out.println("Key = " + display.getKey() + ", Value = " + display.getValue());
        }
    }

    public void sortContact() {
        TreeMap<Long, String> sorted = new TreeMap<>();
        sorted.putAll(list);
        for (Map.Entry<Long, String> display : sorted.entrySet())
            System.out.println("Key = " + display.getKey() + ", Value = " + display.getValue());
    }*/

/*if (list.containsKey(searchNumber)) {
            System.out.print("Number = " + searchNumber + " Name = ");
            System.out.println(list.get(searchNumber));
        } else {
            System.out.println("Not found");
        }*/
        /*for (Map.Entry<Long, String> display : list.entrySet())
            if (list.containsKey(searchNumber)){
            System.out.println("Key = " + display.getKey() + ", Value = " + display.getValue());
        }*/


/* Iterator<Map.Entry<Long, String>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, String> entry = iterator.next();
            if (del.equals(entry.getKey())) {
                iterator.remove();
                System.out.println("Successfully Removed");
            }
        }*/

/*For search
        Iterator<Map.Entry<Long, String>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, String> entry = iterator.next();
            if (searchNumber.equals(entry.getKey())) {
                System.out.println("Name: "+ entry.getValue() + ", Number: " + entry.getKey());
            }
        }*/

/*not working in multiple entries
for (Map.Entry<Long, String> display : list.entrySet()) {
        if (display.getKey().equals(del)) {
        list.remove(display.getKey());
        System.out.println("Successfully Removed");
        }
        }*/
/*Iterator<Map.Entry<Long, String>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
                Map.Entry<Long, String> entry = iterator.next();
        if (del.equals(entry.getKey())) {
        iterator.remove();
        System.out.println("Successfully Removed");
        }
        }*/
/* 1.Sorted hashmap with key using treemap
2.Sortes hashmap with value using comparator
public void sortContact() {
        */
/*TreeMap<Long, String> sorted = new TreeMap<>(contactMap);
        for (Map.Entry<Long, String> display : sorted.entrySet())
            System.out.println("Key = " + display.getKey() + ", Value = " + display.getValue()); *//*


    LinkedHashMap<Long, String> sortedMap = new LinkedHashMap<>();
    ArrayList<String> list = new ArrayList<>();
    for (Map.Entry<Long, String> display: contactMap.entrySet()){
        list.add(display.getValue());
    }
    list.sort(new Comparator<String>() {
        @Override
        public int compare(String value1, String value2) {
            return (value1).compareTo(value2);
        }
    });
    for (String value1: list){
        for (Map.Entry<Long, String> entry:contactMap.entrySet()){
            if (entry.getValue().equals(value1)){
                sortedMap.put(entry.getKey(), value1);
            }
        }
    }
    //System.out.println(sortedMap);
    for (Map.Entry<Long, String> display: sortedMap.entrySet()){
        System.out.println("ContactNo. = " + display.getKey() + ", Name = " + display.getValue());
    }
}*/
/*Old code of list.sort(Comparator.naturalOrder());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String value1, String value2) {
                return (value1).compareTo(value2);
            }
        });*/