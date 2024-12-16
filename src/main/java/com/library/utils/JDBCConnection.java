package com.library.utils;

import com.library.repository.LibraryItemRepository;
import com.library.service.LibraryItemService;

import java.sql.*;

public class JDBCConnection {

    private static JDBCConnection instance;

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "admin123";

    public static synchronized JDBCConnection getInstance() {
        if (instance == null) {
            instance = new JDBCConnection();
        }
        return instance;
    }

    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established.");
        } catch (Exception ex) {
            System.out.println("error connect to database" + ex.getMessage());
        }
        return connection;
    }
}
