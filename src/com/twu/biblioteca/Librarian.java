package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian {
    ArrayList<Book> books = new ArrayList<Book>();

    public Librarian() {
        this.books = this.getBooks();
    }

    public ArrayList<Book> getBooks() {
        for (int i = 0; i < 6; i++) {
            books.add(new Book("book", "author", 2000));
        }
        books.get(0).title = "Java";
        return books;
    }

    public Book checkList(String inputUser) {
        Book book = null;
        for (Book bookAvailable : books) {
            if (inputUser.equals(bookAvailable.title)) book = bookAvailable;
        }
        return book;
    }

    public void checkout(Book book) {
        if (book != null && book.isAvailable) {
            book.isAvailable = false;
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }

    }

    public void returns(Book book) {
        if (book != null && !book.isAvailable) {
            book.isAvailable = true;
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
