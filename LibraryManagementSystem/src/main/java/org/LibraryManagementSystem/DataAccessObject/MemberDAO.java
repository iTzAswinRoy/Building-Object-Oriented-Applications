package org.LibraryManagementSystem.DataAccessObject;

import org.LibraryManagementSystem.Database.DBConnection;
import org.LibraryManagementSystem.Models.Member;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    private String name;
    private String mailID;
    private String phoneNumber;
    private final Connection connection;

    public MemberDAO (String name, String mailID, String phoneNumber, DBConnection dbConnection) {
        this.name = name;
        this.mailID = mailID;
        this.phoneNumber = phoneNumber;
        this.connection = dbConnection.getConnection();
    }

    public MemberDAO(DBConnection dbConnection) {
        this.connection = dbConnection.getConnection();
    }

    public void add() {
        addMember();
    }

    private void addMember() {
        String addMembers = "INSERT INTO Member (Name, Mail_id, Phone_number) VALUES " +
                "(?, ?, ?);";

        Member member = new Member(name, mailID, phoneNumber);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addMembers);

            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getMailId());
            preparedStatement.setString(3, member.getPhoneNumber());

            preparedStatement.executeUpdate();

            System.out.println("\nA new member has been added successfully.");

            String getMemberId = "SELECT Member_ID FROM Member " +
                    "ORDER BY Member_ID DESC " +
                    "LIMIT 1";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(getMemberId);

            while (resultSet.next()){
                int getId = resultSet.getInt("Member_ID");

                System.out.println("Your member ID is " + getId + ".\n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void view() {
        viewMember();
    }

    private void viewMember() {
        String viewMembers = "SELECT Name, Mail_id, Phone_number FROM Member;";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(viewMembers);

            // Here, I'm using formatted printf concept
            // %-10s, %-20s, %-30s: Left-aligns the string to fit in a column of 10, 20, 30 characters.
            System.out.println("\n--------------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-30s\n", "Name", "Mail ID", "Phone Number");
            System.out.println("--------------------------------------------------------");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String mailId = resultSet.getString("Mail_id");
                String phoneNumber = resultSet.getString("Phone_number");

                // Here also applying formatted printf concept
                System.out.printf("%-10s | %-20s | %-30s\n", name, mailId, phoneNumber);
            }
            System.out.println("--------------------------------------------------------\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}