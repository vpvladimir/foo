package vp.filmography;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/vp_db?serverTimezone=UTC&useSSL=false";
        String username = "root";
        String password = "Elena1964";
        System.out.println("Connecting...");

        //try (Connection connection = DriverManager.getConnection(url, username, password)) {
        //    System.out.println("Connection successful!");
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        	Connection connection = DriverManager.getConnection(url, username, password);
        	if (connection != null)  System.out.println("Connection successful!");
        	
        	
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
