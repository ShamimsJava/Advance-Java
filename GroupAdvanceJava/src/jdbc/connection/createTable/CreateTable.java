package jdbc.connection.createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shamim", "shamim");
            String createTable = "create table students("
                    + "st_id number(10) primary key,"
                    + "st_name varchar2(15) not null,"
                    + "st_district varchar2(15)"
                    + ")";
            PreparedStatement st = con.prepareStatement(createTable);
            st.executeUpdate();
            System.out.println(":::::Table is created:::::");
        } catch (Exception e) {
            System.err.println("This table name is already created.....");
        }

    }
}
