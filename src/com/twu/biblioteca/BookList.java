package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        books = new ArrayList<Book>();
        for (int i = 0; i < 6; i++) {
            books.add(new Book("book", "author", 2000));
        }
        return books;
    }

    public ArrayList<Book> availableBooks() {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable == false) books.remove(i);
        }
        System.out.println(books);
        return books;
    }
}
