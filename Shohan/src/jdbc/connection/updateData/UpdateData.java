package jdbc.connection.updateData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            String updateData = "update students set st_name = 'Urmila' where st_id = 103";
            PreparedStatement st = con.prepareStatement(updateData);
            st.executeUpdate();
            System.out.println(":::::Data is updated:::::");
        } catch (Exception e) {
            System.err.println("Data is not updated....");
        }
    }
}
