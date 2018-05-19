package com.twu.biblioteca;

public class Movie extends LibraryItem {
    public String name;
    public String director;
    public int rating;

    public Movie(String name, String director, int year, int rating) {
        super("movie");
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
