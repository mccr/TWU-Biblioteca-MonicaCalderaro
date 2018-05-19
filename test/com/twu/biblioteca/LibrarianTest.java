package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    Book book;
    @Before
    public void setUp() {
        librarian = new Librarian();
        book = new Book("Java", "author", 2000);
    }

    @Test
    public void shouldHaveAListOfBooks() {

        assertEquals(6, librarian.bookList.size());
    }

    @Test
    public void shouldReturnTheStatusOfABook() {

        assertTrue(librarian.bookList.get(0).isAvailable());
    }

    @Test
    public void shouldBeAbleToCheckoutBookAndMarkItUnavailableAndShowSuccessMessage() {

        librarian.checkout(book);

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());
        assertFalse(book.isAvailable());
    }

    @Test
    public void shouldBeAbleToShowAUnsuccessfulCheckoutMessage() {
        book = null;

        librarian.checkout(book);

        assertEquals("That item is not available.", outContent.toString().trim());
    }

    @Test
    public void shouldBeAbleToReturnBooksAndMarkItAsAvailableAndShowSuccessMessage() {
        book.updateAvailability();

        librarian.returns(book);

        assertEquals("Thank you for returning the book", outContent.toString().trim());
        assertTrue(book.isAvailable());
    }

    @Test
    public void shouldBeAbleToShowUnsuccessfulReturnMessage() {
        librarian.returns(book);

        assertEquals("That is not a valid item to return.", outContent.toString().trim());
    }

    @Test
    public void shouldCheckForAnExistingBookInBookList() {
        LibraryItem bookChecked = librarian.checkList("Head First Java", "book");
        Book book = (Book) bookChecked;

        assertEquals("Head First Java", book.title);
    }

    @Test
    public void shouldHaveAListOfMovies() {
        assertEquals(3, librarian.movieList.size());
    }

    @Test
    public void shouldCheckForAnExistingBookInMovieList() {
        LibraryItem movieChecked = librarian.checkList("Butterfly Effect", "movie");
        Movie movie = (Movie) movieChecked;

        assertEquals("Butterfly Effect", movie.name);
    }

    @Test
    public void shouldBeAbleToCheckoutMoviesAndMarkItUnavailableAndShowSuccessMessage() {
        LibraryItem movieChecked = librarian.checkList("Butterfly Effect", "movie");
        Movie movie = (Movie) movieChecked;

        librarian.checkout(movieChecked);

        assertEquals("Thank you! Enjoy the movie", outContent.toString().trim());
        assertFalse(movie.isAvailable());
    }

    @Test
    public void shouldBeAbleToShowAUnsuccessfulCheckoutMovieMessage() {
        LibraryItem movieChecked = librarian.checkList("Butterfly", "movie");

        librarian.checkout(movieChecked);

        assertEquals("That item is not available.", outContent.toString().trim());
    }
}
