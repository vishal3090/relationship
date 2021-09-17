package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.29.183:5432/local","guest","guest");

            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

            //String sql = "INSERT INTO REGISTRATION(id, first,last, age)";
            //String sql = "DROP TABLE REGISTRATION";

            stmt.executeUpdate(sql);
            System.out.println("Table is created");
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println("Error: "+e);
        }
    }
}
