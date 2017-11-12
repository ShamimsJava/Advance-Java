package jdbc.connection.datainsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            String insertData = "insert into students values(101, 'Shamim', 'Lalmonirhat')";
            PreparedStatement st = con.prepareStatement(insertData);
            st.executeUpdate();
            System.out.println(":::::Data is inserted:::::");
        } catch (Exception e) {
            System.err.println("Data is not inserted....");
        }
    }
}
