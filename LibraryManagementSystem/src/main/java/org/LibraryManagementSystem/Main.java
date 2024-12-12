package org.LibraryManagementSystem;

import org.LibraryManagementSystem.DataAccessObject.BookDAO;
import org.LibraryManagementSystem.DataAccessObject.MemberDAO;
import org.LibraryManagementSystem.Database.DBConnection;

import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);

        DBConnection dbConnection = new DBConnection();
        dbConnection.createBookDB();
        dbConnection.createMemberDB();

        System.out.println("\nLibrary management system:");

        while (true) {
            System.out.println("1. Add new book.\n2. View all books.\n3. Register a new member.\n4. View all members.\n5. Exit");
            System.out.println("\nEnter an option:");

            int option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter the title: ");
                    String title = in.nextLine();

                    System.out.println("Enter the author name: ");
                    String author = in.nextLine();

                    System.out.println("Enter the genre: ");
                    String genre = in.nextLine();


                    System.out.println("Enter the no of copies available: ");
                    int no_of_copies  = in.nextInt();

                    BookDAO bookDAO = new BookDAO(title, author, genre, no_of_copies, dbConnection);
                    bookDAO.add();
                }

                case 2 -> {
                    BookDAO bookDAO = new BookDAO(dbConnection);
                    bookDAO.view();
                }

                case 3 -> {
                    System.out.println("Enter the name:");
                    String name = in.nextLine();

                    System.out.println("Enter the mail ID:");
                    String mailId = in.nextLine().toLowerCase();

                    System.out.println("Enter the phone number:");
                    String phoneNumber = in.nextLine();

                    MemberDAO memberDAO = new MemberDAO(name, mailId, phoneNumber, dbConnection);
                    memberDAO.add();
                }

                case 4 -> {
                    MemberDAO memberDAO = new MemberDAO(dbConnection);
                    memberDAO.view();
                }

                case 5 -> {
                    System.out.println("\nExiting....");
                    return;
                }

                default ->
                        System.err.println("Invalid input!");
            }
        }
    }
}