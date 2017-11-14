package com.urmi.jdbc.connection.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataQuery {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // set driver
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "megha", "megha");
            String sql = "select * from students";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"       "+rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
