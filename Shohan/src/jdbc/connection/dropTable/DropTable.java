package jdbc.connection.dropTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DropTable {
     public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            String dropTable = "drop table students";
            PreparedStatement st = con.prepareStatement(dropTable);
            st.executeUpdate();
            System.out.println(":::::Table is dropped:::::");
        } catch (Exception e) {
            System.err.println("Table is not dropped....");
        }
    }
}
