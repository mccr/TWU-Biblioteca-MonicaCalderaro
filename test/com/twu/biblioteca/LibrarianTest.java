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

    @Test
    public void shouldBeAbleToCheckoutBook() {
        Librarian librarian = new Librarian();
        Book book = new Book("book", "author", 2000);
        librarian.checkout(book);

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());
    }
}
