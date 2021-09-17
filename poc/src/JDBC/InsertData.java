package JDBC;

import java.sql.*;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

            Statement statement = connection.createStatement();
            System.out.println("Inserting records into the table");
            String sql = "INSERT INTO registration VALUES(4, 'Bhavin', 'Darji', 28)";
            statement.executeUpdate(sql);
        }
        catch (SQLException e){
            System.out.println("Error: "+e);
        }
    }
}
