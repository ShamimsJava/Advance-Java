package com.shamim.jdbc.createtable;

import com.shamim.jdbc.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestCreateTable {
    static Connection conn = DbConnection.getConnections("hr", "hr");
    public static void main(String[] args) {
        String sql = "create table students("
                + "student_id integer primary key,"
                + "student_name varchar2(20) not null)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            int i = pstm.executeUpdate();
            System.out.println("Table has been created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
