package com.shamim.connection.tableCreate;

import com.shamim.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TableCreation {
    public static void main(String[] args) {
        try {
            Connection conn = DbConnection.getConnections("shamim", "shamim");
            String sql = "create table students("
                    + "student_id number(5) primary key,"
                    + "student_name varchar2(15) not null)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("Table is created...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
