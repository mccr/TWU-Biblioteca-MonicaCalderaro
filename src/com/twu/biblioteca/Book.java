package com.twu.biblioteca;

public class Book extends LibraryItem {

    public String title;
    public String author;

    public Book(String title, String author, int year) {
        super("book");
        this.title = title;
        this.author = author;
        this.year = year;
    }

}
