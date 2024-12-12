package org.LibraryManagementSystem.Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBConnection {
    private final String url = "jdbc:mysql://localhost:3306/Library";
    private final String username = "root";
    private final String password = "AswinRoy@MySQL.com";
    private final Connection connection;


    public DBConnection() throws SQLException {
        this.connection = DriverManager.getConnection(this.url, this.username, this.password);
        System.out.println("Connection established successfully:");
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void createBookDB() {
        try {
            Statement statement = connection.createStatement();
            String createBookTable = "CREATE TABLE Book (Book_ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                        "Title VARCHAR(200) NOT NULL," +
                        "Author VARCHAR(200) NOT NULL," +
                        "Genre VARCHAR(200) NOT NULL," +
                        "No_of_copies INT);";

            statement.execute(createBookTable);
            System.out.println("Table 'Book' created successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMemberDB() {
        try {
            Statement statement = connection.createStatement();

            String createMemberTable = "CREATE TABLE Member (Member_ID INT PRIMARY KEY AUTO_INCREMENT," +
                        "Name VARCHAR(200) NOT NULL," +
                        "Mail_id VARCHAR(200) NOT NULL," +
                        "Phone_number VARCHAR(200) NOT NULL); ";

            statement.execute(createMemberTable);
            System.out.println("Table 'Member' created successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}