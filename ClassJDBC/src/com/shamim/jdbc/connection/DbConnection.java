package com.shamim.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static Connection connection;

    public static Connection getConnections(String user, String password) {

        try {
            Class.forName(DRIVERNAME);
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println(":::::Connected:::::");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
