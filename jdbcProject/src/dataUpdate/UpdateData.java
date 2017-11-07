package dataUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateData {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            //Statement stmt = con.createStatement();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            //stmt.executeUpdate("delete from employees where eid = 104");
            ResultSet rs = stmt.executeQuery("select * from employees");
            
            rs.absolute(2);
            //while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
            //}
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
