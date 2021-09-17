package JDBC;

import java.sql.*;

public class GroupData {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

            Statement statement = connection.createStatement();
            String sql = "SELECT COUNT(id),age FROM registration GROUP BY age HAVING COUNT(id) > 2";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                System.out.println("number: "+result.getInt("count"));
                System.out.println("Age: "+result.getInt("age"));
            }
            result.close();
        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: "+e);
        }
    }
}
