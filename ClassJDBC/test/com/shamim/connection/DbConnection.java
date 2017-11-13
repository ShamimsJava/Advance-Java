package com.shamim.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static Connection connection;
    public static Connection getConnections(String user, String password){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
