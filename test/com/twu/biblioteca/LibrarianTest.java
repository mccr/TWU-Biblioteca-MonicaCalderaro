package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibrarianTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Librarian librarian;
    ArrayList<Book> libraryBooks;
    Book book;
    @Before
    public void setUp() {
        librarian = new Librarian();
        libraryBooks = librarian.getBooks();
        book = new Book("book", "author", 2000);
    }

    @Test
    public void shouldHaveAListOfBooks() {

        assertEquals(6, libraryBooks.size());
    }

    @Test
    public void shouldReturnTheStatusOfABook() {

        assertEquals(true, libraryBooks.get(0).isAvailable);
    }

    @Test
    public void shouldBeAbleToCheckoutBookAndMarkItUnavailableAndShowSuccessMessage() {

        librarian.checkout(book);

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());
        assertEquals(false, book.isAvailable);
    }

    @Test
    public void shouldBeAbleToShowAUnsuccessfulCheckoutMessage() {
        book.isAvailable = false;

        librarian.checkout(book);

        assertEquals("That book is not available.", outContent.toString().trim());
    }

    @Test
    public void shouldBeAbleToReturnBooksAndMarkItAsAvailableAndShowSuccessMessage() {
        book.isAvailable = false;

        librarian.returns(book);

        assertEquals("Thank you for returning the book.", outContent.toString().trim());
        assertEquals(true, book.isAvailable);
    }

    @Test
    public void shouldBeAbleToShowUnsuccessfulReturnMessage() {
        librarian.returns(book);

        assertEquals("That is not a valid book to return.", outContent.toString().trim());
    }
}
