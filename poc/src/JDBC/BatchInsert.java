package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

//delete table, create table, insert data, rollback
public class BatchInsert {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/local", "postgres", "postgres");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO customer1 VALUES(?,?,?)")) {
            //Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            Random random = new Random();
            int batchSize = 50;
            int count = 0;
            int i;
            for (i = 1; i <= 510; i++) {
                int age = random.nextInt(100);
                statement.setInt(1, i);
                statement.setString(2, "Bhavin" + i);
                statement.setInt(3, age);
                statement.addBatch();
                if (i % batchSize == 0) {
                    statement.executeBatch();
                    System.out.println("Commit the batch: " + (++count));
                }
            }
            //statement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
