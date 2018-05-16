package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        book = new Book("Java", "author", 2000);
    }

    @Test
    public void shouldHaveAListOfBooks() {

        assertEquals(6, librarian.books.size());
    }

    @Test
    public void shouldReturnTheStatusOfABook() {

        assertTrue(librarian.books.get(0).isAvailable);
    }

    @Test
    public void shouldBeAbleToCheckoutBookAndMarkItUnavailableAndShowSuccessMessage() {

        librarian.checkout(book);

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());
    }

    @Test
    public void shouldBeAbleToShowAUnsuccessfulCheckoutMessage() {
        book = null;

        librarian.checkout(book);

        assertEquals("That book is not available.", outContent.toString().trim());
    }

    @Test
    public void shouldBeAbleToReturnBooksAndMarkItAsAvailableAndShowSuccessMessage() {
        book.isAvailable = false;

        librarian.returns(book);

        assertEquals("Thank you for returning the book.", outContent.toString().trim());
    }

    @Test
    public void shouldBeAbleToShowUnsuccessfulReturnMessage() {
        librarian.returns(book);

        assertEquals("That is not a valid book to return.", outContent.toString().trim());
    }

    @Test
    public void shouldCheckForAnExistingBookInBookList() {
        Book bookChecked = librarian.checkList("Java");

        assertEquals("Java", bookChecked.title);
    }
}
