package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class BatchData {
    public static void main(String[] args) {
        try {
            // Create customer class with field, id, name, age
            // Generate 510/1010 random entries of customers
            // Insert all the customer in batch of 50/100


            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/local", "postgres", "postgres");
            Statement statement = connection.createStatement();
            for (int i = 1; i <= 500; i++) {
                String name = "ABC" + i;
                statement.addBatch("INSERT INTO customer VALUES("+i+",'Bhavin',9999999999)");
            }
            int[] result = statement.executeBatch();
            System.out.println("The number of rows inserted: "+result.length);
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
