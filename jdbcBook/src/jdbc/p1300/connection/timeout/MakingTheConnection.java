package jdbc.p1300.connection.timeout;

import java.sql.Connection;
import java.sql.DriverManager;

public class MakingTheConnection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.setLoginTimeout(60);
            Connection databaseConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            System.out.println("Connection is: "+databaseConnection);
            System.out.println("Login timeout : " + DriverManager.getLoginTimeout());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
