package jdbc.p1299.connection.complex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ComplexConnection {
    public static void main(String[] args) {
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String sourceURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        try {
            Class.forName(driverName);
            Properties prop = new Properties();
            prop.setProperty("user", "hr");
            prop.setProperty("password", "hr");
            Connection databaseConnection = DriverManager.getConnection(sourceURL, prop);
            System.out.println("Connection is : " + databaseConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
