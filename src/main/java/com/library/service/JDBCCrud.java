package com.library.service;

import com.library.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCrud {

    private static final Connection con = JDBCConnection.getInstance().connect();
    public  void fetchData() throws SQLException {
        String query = "select * from book";
        try (Connection connection = con;
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

    public  void updateData() throws SQLException {
        String query = "UPDATE book SET status = ? WHERE book_id = ?";
        try (Connection connection = con;
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "BORROWED");
            preparedStatement.setInt(2,8);
            preparedStatement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  void deleteData() throws SQLException {
        String query = "delete from book WHERE book_id = ?";
        try (Connection connection = con;
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, 11);
            preparedStatement.executeUpdate();
            System.out.println("Record delete.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
