package com.urmi.jdbc.connection.updatedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // set driver
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "megha", "megha");
            String sql = "update students set st_name = 'shihab' where st_id = '102'";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("Data is updated...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
