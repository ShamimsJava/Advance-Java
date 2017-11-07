/*
value insert in table
 */
package dataUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ValueInsert {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");

            PreparedStatement stmt = con.prepareStatement("insert into employees values(104,'Harry')");
            
           

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
