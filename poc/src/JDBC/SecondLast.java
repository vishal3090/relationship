package JDBC;

import java.sql.*;

public class SecondLast {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM (SELECT row_number() OVER (ORDER BY id desc) r, * FROM registration) q WHERE r = 2";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                System.out.println("Id: "+result.getInt("id"));
                System.out.println("First Name: "+result.getString("first"));
                System.out.println("Last Name: "+result.getString("last"));
                System.out.println("Age: "+result.getInt("age"));
            }
            result.close();
        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: "+e);
        }
    }
}
