package com.urmi.jdbc.connection.insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataInsert {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student id: ");
        int id = sc.nextInt();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // set driver
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "megha", "megha");
            String sql = "insert into Students values(?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.executeUpdate();
            System.out.println("Data is inserted...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
