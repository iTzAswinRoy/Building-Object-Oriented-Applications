package org.LibraryManagementSystem.Models;

public class Book {
    private final String title;
    private final String author;
    private final String genre;
    private final int no_of_copies;

    public Book (String title, String author, String genre, int no_of_copies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.no_of_copies = no_of_copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getNo_of_copies() {
        return no_of_copies;
    }
}