package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    BookList bookList;
    ArrayList<Book> libraryBooks;

    @Before
    public void setUp() throws Exception {
        bookList = new BookList();
        libraryBooks = bookList.getBooks();
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
    public void shouldOnlyShowAvailableBooks() {
        libraryBooks.get(0).isAvailable = false;
        ArrayList<Book> booksAvailable = bookList.availableBooks();

        assertEquals(5, booksAvailable.size());
    }


}
