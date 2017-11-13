package com.shamim.connection;

public class TestConnection {
    public static void main(String[] args) {
        DbConnection.getConnections("shamim", "shamim");
        System.out.println("Connection ok.....");
    }
}
