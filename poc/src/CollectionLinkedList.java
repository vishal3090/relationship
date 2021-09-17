import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(15);
        l2.add(17);
        l2.add(18);
        l1.add(6);
        l1.add(7);
        l1.add(4);
        l1.add(9);
        l1.add(6);
        l1.add(1);
        l1.add(72);
        l1.add(73);
        l1.add(7);
        l1.add(17);
        l1.add(7);
        /*for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i));
            System.out.print(", ");
        }
        System.out.println("\n");
        l1.addLast(3);
        System.out.println("After addLast");
        System.out.println(l1);
        l1.addFirst(34);
        System.out.println("After addFirst");
        System.out.println(l1);*/

        ArrayList<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("javascript");
        languages.add("jquery");
        languages.add("angularjs");
        languages.add("jquery");
        languages.add("angularjs");
        languages.add("javascript");
        languages.add("jquery");
        languages.add("angularjs");
        languages.add("jquery");

        System.out.println(languages);
        System.out.println(languages.remove("jquery"));
        System.out.println(languages);
    }
}
