package com.mycompany.createtable;

import com.mycompany.dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {
        try {
            Connection conn = DbConnection.getConnections("shamim", "shamim");
            String sql = "create table Students("
                    + "st_id number(5) primary key,"
                    + "st_name varchar2(15) not null)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("Table is created...");
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
