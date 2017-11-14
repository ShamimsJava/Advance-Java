package com.urmi.jdbc.connection.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // set driver
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "megha", "megha");
            String sql = "delete from students where st_id = 102";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("Data is deleted...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
