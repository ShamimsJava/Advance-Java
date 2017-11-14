package com.urmi.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // set driver
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "megha", "megha");
            System.out.println("::::Connected::::");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection is not build...");
        }
    }
}
