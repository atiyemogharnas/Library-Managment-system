package com.library.utils;

import java.sql.*;

public class JDBCConnection {

    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "admin123";

    public static Connection connect() {
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

    public static void fetchData() throws SQLException {
        String query = "select * from book";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String status = resultSet.getString("status");
                System.out.println(title + "-" + author + "-" + status);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateData() throws SQLException {
        String query = "UPDATE book SET status = ? WHERE book_id = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "BORROWED");
            preparedStatement.setInt(2,8);
            preparedStatement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteData() throws SQLException {
        String query = "delete from book WHERE book_id = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, 11);
            preparedStatement.executeUpdate();
            System.out.println("Record delete.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
