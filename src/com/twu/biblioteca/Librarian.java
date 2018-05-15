package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian {
    public static ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 6; i++) {
            books.add(new Book("book", "author", 2000));
        }
        return books;
    }

    public void checkout(Book book) {
        if (book.isAvailable == true) {
            book.isAvailable = false;
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }

    }

    public void returns(Book book) {
        if (book.isAvailable == false) {
            book.isAvailable = true;
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }

    }
}
