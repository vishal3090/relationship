package JDBC;

import java.sql.*;

public class UpdateData {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

            Statement statement = connection.createStatement();
            String sql = "UPDATE registration SET age = 25 WHERE id in (1)";
            statement.executeUpdate(sql);
            String query = "select * from registration";
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                System.out.println("Id: "+result.getInt("id"));
                System.out.println("First Name: "+result.getString("first"));
                System.out.println("Last Name: "+result.getString("last"));
                System.out.println("Age: "+result.getInt("age"));
            }
            result.close();
        }
        catch (Exception e){
            System.out.println("Error: "+e);
        }
    }
}
