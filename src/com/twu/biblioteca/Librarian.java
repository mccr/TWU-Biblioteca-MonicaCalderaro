package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Librarian {
    ArrayList<Book> bookList;

    public Librarian() {
        this.bookList = this.getBooks();
    }

    public ArrayList<Book> getBooks() {
        bookList = new ArrayList<Book>();
        for (int i = 0; i < 6; i++) {
            bookList.add(new Book("book", "author", 2000));
        }

        String[] titles = {"Head First Java", "CLean Code", "Design Pattern", "JavaScript", "Scala Workshop", "RoR Design"};
        String[] authors = {"JK Rolling", "KK Rachel", "Denis Newton", "Marc Jacobs", "Laurie Moore", "Jesus Manch"};
        int[] years = {2000, 1990, 2004, 2018, 1989, 2002};
        for (int i = 0; i < bookList.size(); i++) {
            bookList.get(i).title = titles[i];
            bookList.get(i).author = authors[i];
            bookList.get(i).year = years[i];
        }
        return bookList;
    }

    public Book checkList(String inputUser) {
        Book book = null;
        for (Book bookAvailable : bookList) {
            this.printMessage(bookAvailable.title);
            if (inputUser.equals(bookAvailable.title)) book = bookAvailable;
        }
        return book;
    }

    public void checkout(Book book) {
        if (book != null && book.isAvailable) {
            book.isAvailable = false;
            this.printMessage("Thank you! Enjoy the book");
        } else {
            this.printMessage("That book is not available.");
        }

    }

    public void returns(Book book) {
        if (book != null && !book.isAvailable) {
            book.isAvailable = true;
            this.printMessage("Thank you for returning the book.");
        } else {
            this.printMessage("That is not a valid book to return.");
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
