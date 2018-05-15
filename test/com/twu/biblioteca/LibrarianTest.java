package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    Book book;
    @Before
    public void setUp() throws Exception {
        librarian = new Librarian();
        book = new Book("book", "author", 2000);
    }

    @Test
    public void shouldBeAbleToCheckoutBookAndMarkItUnavailableAndShowSuccessMessage() {

        librarian.checkout(book);

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());
        assertEquals(false, book.isAvailable);
    }

    @Test
    public void shouldBeAbleToShowAUnsuccessfulMessage() {
        book.isAvailable = false;

        librarian.checkout(book);

        assertEquals("That book is not available.", outContent.toString().trim());
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
    }
}
