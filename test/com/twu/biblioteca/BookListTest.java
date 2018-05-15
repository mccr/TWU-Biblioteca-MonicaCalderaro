package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {


    @Test
    public void shouldShowAListOfBooks() {
        //Given
        BookList bookList = new BookList();
        //When
        ArrayList<Book> booksAvailable = bookList.getBooks();
        //Then
        assertEquals(6, booksAvailable.size());
    }

    @Test
    public void shouldReturnTheStatusOfABook() {
        BookList bookList = new BookList();
        ArrayList<Book> booksAvailable = bookList.getBooks();
        assertEquals(true, booksAvailable.get(0).isAvailable);
    }
}
