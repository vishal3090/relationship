import java.util.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.InputMismatchException;

public class Demo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        /*String a = "2";
        String b = "3";
        String c = a+b;
        System.out.println(c);*/

        //String re = "[+*/-]";
        /*String operator;
        Scanner sc = new Scanner(System.in);
        operator = sc.nextLine();

        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(operator);

        boolean result = mt.matches();
        System.out.println(result);
*/

        //Index : User input string index
        /*Scanner sc = new Scanner(System.in);
        String s1;
        String s2;

        System.out.println("Enter a string: ");
        s1 = sc.nextLine();
        System.out.println("Enter a substring: ");
        s2 = sc.nextLine();
        int index = s1.indexOf(s2);
        System.out.println("Index of this word: "+index);
*/
///////String demo
        /*String string = "The best of both worlds";
        int count = 0;
        char search = 't';
        //count each characters except space
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i) == search)
                count++;
        }
        System.out.println("String length: "+string.length());
        System.out.println("The character "+search+" appears "+count+" times");
*/

  ///////////Multiple entry in addition
        /*boolean firstChance = true;
        boolean secondChance = true;
        double sum = 0;
        while (secondChance){
            try{
                while (firstChance){

                    try{
                        System.out.print("Please enter a number: ");
                        double input = sc.nextDouble();
                        sum = sum + input;
                    }
                    catch (InputMismatchException ex){
                        firstChance = false;
                    }
                    System.out.print("Please enter a number to continue or something else to terminate: ");
                    double input = sc.nextDouble();
                    sum = sum + input;
                    firstChance = true;
                }
            }
            catch (InputMismatchException e){
                secondChance = false;
            }
        }
        System.out.print("The sum of the entered values is " + sum);
*/
        /*String[] exchange = new String[5];
        exchange[0] = "Rupees";
        exchange[1] = "Dollar";
        exchange[2] = "Euro";
        exchange[3] = "Pound";
        int index1 = sc.nextInt();
        System.out.println(exchange[index1]);*/

        int[] number = {1,3,5,9,11};
        int input = sc.nextInt();
        for (int i=0; i<+number.length-1; i++){

                int sum = number[i]+number[i];
                if(i != i && input == sum){
                    boolean flag = true;
                    System.out.println(flag);
                    return;
                }
            }
        }

    }

/*
    package FileHandling;

            import java.util.Scanner;

public class ArrayAddition {
    public static void main(String[] args) {
        int[] number = {1, 3, 5, 6, 8, 9, 11};
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        boolean flag = true;
        for (int i = 0; i < +number.length - 1; i++) {
            for (int j = 0; j <= number.length - 1; j++) {
                int sum = number[i] + number[j];
                if (i != j && input == sum) {

                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
*/


/*    int[] number = {1, 3, 5, 6, 8, 9, 11};
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    boolean flag = true;
        for (int i = 0; i < +number.length - 1; i++) {
        for (int j = 0; j <= number.length - 1; j++) {
        int sum = number[i] + number[j];
        if (i != j && input == sum) {

        System.out.println(flag);
        return;
        }
        }
        }
        if (flag) {
        System.out.println("false");
        }*/

/*
package FileHandling;

        import java.util.Scanner;

public class ArrayAddition {

    public boolean check(int[] number, int input) {
        boolean flag = false;
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j <= number.length - 1; j++) {
                int sum = number[i] + number[j];
                if (i != j && input == sum) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        int arraySize = sc.nextInt();
        int[] number = new int[arraySize];
        System.out.println("Please enter numbers");
        boolean checkType = sc.hasNextInt();
        for (int i = 0; i < arraySize; i++) {
            number[i] = sc.nextInt();
            if(i == 20){
                int a = sc.nextInt();
            }
        }

        */
/*int k = 0;
        while (k < number.length && checkType) {
            number[k] = sc.nextInt();
            k++;
        }*//*


        System.out.println("Array numbers are");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println("\nEnter number to check addition");

        int input = sc.nextInt();
        FileHandling.ArrayAddition add = new FileHandling.ArrayAddition();
        boolean checkAddition = add.check(number, input);
        System.out.println(checkAddition);
    }
}*/

/////////////String
/*
package FileHandling;

        import java.util.Scanner;

public class ArrayAddition {

    public boolean check(String[] number, String input) {
        boolean flag = false;
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j <= number.length - 1; j++) {
                String sum = number[i] + number[j];
                if (i != j && input == sum) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        int arraySize = sc.nextInt();
        String[] number = new String[arraySize];
        System.out.println("Please enter numbers");
        boolean checkType = sc.hasNextInt();
        for (int i = 0; i < arraySize; i++) {
            number[i] = sc.next();
            if(number[i].equalsIgnoreCase("exit")){
                System.exit(0);
            }
        }

        System.out.println("Array numbers are");
        for (int i = 0; i < arraySize; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println("\nEnter number to check addition");

        String input = sc.next();
        FileHandling.ArrayAddition add = new FileHandling.ArrayAddition();
        boolean checkAddition = add.check(number, input);
        System.out.println(checkAddition);
    }
}*/

/*
for (int i = 0; i < n; i++) {
        number.add(sc.next());
        if(number.get(i).equalsIgnoreCase("exit")){
        System.out.println(number.get(2));
        System.out.println("Enter you want to terminate type 'yes' and continue type 'no'");
        String option = sc.next();
        if (option.equalsIgnoreCase("yes")){
        number.remove(i);
        break;
        }
        else if(option.equalsIgnoreCase("no")) {
        number.remove(i);
        System.out.println("enter number");
        }
        }
        }*/

/*

try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example","postgres","postgres")) {
        String sql = "INSERT INTO Contacts (Full_Name, Email, Phone) VALUES(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Vishal Rathod");
        preparedStatement.setString(2, "email@email.com");
        preparedStatement.setLong(3, 9999999999l);

        int row = preparedStatement.executeUpdate();
        if (row > 0) {
        System.out.println("A row has been inserted successfully");
        }
        sql = "SELECT * FROM Contacts";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
        int id = result.getInt("ID");
        String Name = result.getString("Full_name");
        String Email = result.getString("Email");
        Long Phone = result.getLong("Phone Number");
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }*/

/*
try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM registration";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
        System.out.println("Id: "+result.getInt("id"));
        System.out.println("First Name: "+result.getString("first"));
        System.out.println("Last Name: "+result.getString("last"));
        System.out.println("Age: "+result.getInt("age"));
        }
        } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        }*/
