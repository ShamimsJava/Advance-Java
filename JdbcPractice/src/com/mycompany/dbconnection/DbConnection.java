package com.mycompany.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static Connection conn;
    
    public static Connection getConnections(String user, String password){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println(":::::Connected:::::");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch(SQLException se){
            se.printStackTrace();
        }
        return conn;
    }
}
