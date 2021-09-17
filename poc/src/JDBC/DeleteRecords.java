package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteRecords {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local", "guest", "guest");
            Statement statement = connection.createStatement();

            String sql = "DELETE FROM registration WHERE id = 3";
            statement.executeUpdate(sql);

            String query = "SELECT * FROM registration";
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                System.out.println("Id: "+result.getInt("id"));
                System.out.println("First Name: "+result.getString("first"));
                System.out.println("Last Name: "+result.getString("last"));
                System.out.println("Age: "+result.getInt("age")+"\n");
            }
            result.close();
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
}
