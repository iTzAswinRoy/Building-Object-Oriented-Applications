package org.LibraryManagementSystem.DataAccessObject;

import org.LibraryManagementSystem.Models.Book;
import org.LibraryManagementSystem.Database.DBConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BookDAO {
    private String title;
    private String author;
    private String genre;
    private int no_of_copies;
    private final Connection connection;

    public BookDAO (String title, String author, String genre, int no_of_copies, DBConnection dbConnection) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.no_of_copies = no_of_copies;
        this.connection = dbConnection.getConnection();
    }

    public BookDAO (DBConnection dbConnection) {
        this.connection = dbConnection.getConnection();
    }

    public void add() {
        addBook();
    }

    private void addBook() {
        String addBook = "INSERT INTO Book (Title, Author, Genre, No_of_copies) VALUES" +
                "(?, ?, ?, ?);";

        Book book = new Book(title, author, genre, no_of_copies);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addBook);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setInt(4, book.getNo_of_copies());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nA new book was added successfully.");
            }

            String getBookId = "SELECT Book_ID FROM Book " +
                    "ORDER BY Book_ID DESC " +
                    "LIMIT 1;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getBookId);

            while (resultSet.next()) {
                int bookId = resultSet.getInt("Book_ID");

                System.out.println("Your book ID is " + bookId + ".\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void view() {
        viewBook();
    }

    private void viewBook() {
        String viewBook = "SELECT Title, Author, Genre, No_of_copies FROM Book;";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(viewBook);

            // Here, I'm using formatted printf concept
            // %-15s, %-15s, %-10s, %-15s: Left-aligns the string to fit in a column of 15, 15, 10, 15 characters.
            System.out.println("\n----------------------------------------------------------------");
            System.out.printf("%-15s | %-15s | %-10s | %-15s\n", "Book ID", "Title", "Author", "No. of copies");
            System.out.println("----------------------------------------------------------------");

            while (resultSet.next()) {
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                String genre = resultSet.getString("Genre");
                int noOfCopies = resultSet.getInt("No_of_copies");

                // Here also applying formatted printf concept
                System.out.printf("%-15s | %-15s | %-10s | %-15s\n", title, author, genre, noOfCopies);
            }
            System.out.println("----------------------------------------------------------------\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}