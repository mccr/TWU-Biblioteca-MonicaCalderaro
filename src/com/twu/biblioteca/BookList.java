package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 6; i++) {
            books.add(new Book("book", "author", 2000));
        }
        return books;
    }

}
