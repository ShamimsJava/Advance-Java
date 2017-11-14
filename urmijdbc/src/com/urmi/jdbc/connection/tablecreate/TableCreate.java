package com.urmi.jdbc.connection.tablecreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TableCreate {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // set driver
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "megha", "megha");
            String sql = "create table Students(st_id number(5) primary key, st_name varchar2(15) not null)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("Table is created...");
        } catch (Exception e) {
        }
    }
}
