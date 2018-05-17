package com.twu.biblioteca;

public class Book {

    public String title;
    public String author;
    public int year;
    public boolean isAvailable = true;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

}
