package JDBC;

import java.sql.*;

public class FirstDB {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM registration order by id";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                System.out.print("Id: "+result.getInt("id")+", ");
                System.out.print("First Name: "+result.getString("first")+", ");
                System.out.print("Last Name: "+result.getString("last")+", ");
                System.out.print("Age: "+result.getInt("age")+"\n");
            }
            result.close();
        } catch (SQLException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Error: "+e);
        }
    }
}
