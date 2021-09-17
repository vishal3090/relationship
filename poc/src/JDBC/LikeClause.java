package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LikeClause {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local", "guest", "guest");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM registration WHERE first LIKE '%ay%'";

            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                System.out.println("ID: "+result.getInt("id"));
                System.out.println("First Name: "+result.getString("first"));
                System.out.println("Last Name: "+result.getString("last"));
                System.out.println("Age: "+result.getInt("age"));
            }
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
}
