package jdbc.p1297.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MakingTheConnection {
    public static void main(String[] args) {
        try {
            // Load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection databaseConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            System.out.println("Connection is: "+databaseConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
