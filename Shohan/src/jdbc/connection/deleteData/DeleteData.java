package jdbc.connection.deleteData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {
     public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            String deleteData = "delete from students where st_id = 101";
            PreparedStatement st = con.prepareStatement(deleteData);
            st.executeUpdate();
            System.out.println(":::::Data is deleted:::::");
        } catch (Exception e) {
            System.err.println("Data is not deleted....");
        }
    }
}
