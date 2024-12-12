package org.LibraryManagementSystem.Models;

public class Member {
    private final String name;
    private final String mailId;
    private final String phoneNumber;

    public Member(String name, String mailId, String phoneNumber) {
        this.name = name;
        this.mailId = mailId;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getMailId() {
        return mailId;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }
}