package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            System.out.println(":::::Connected:::::");
        } catch (Exception e) {
            System.err.println("Not connected.....");
        }
    }
}
