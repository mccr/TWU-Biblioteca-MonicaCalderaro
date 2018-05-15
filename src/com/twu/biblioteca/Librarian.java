package com.twu.biblioteca;

public class Librarian {
    public void checkout(Book book) {
        if (book.isAvailable == true) {
            book.isAvailable = false;
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }

    }

    public void returns(Book book) {
        System.out.println("book return");
    }
}
