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
        if (book.isAvailable == false) {
            book.isAvailable = true;
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }

    }
}
