package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldHaveTitleAuthorAndYear() {
        Book book = new Book("Head First Java", "J. Rollings", 2007);
        assertEquals("Head First Java", book.title);
        assertEquals("J. Rollings", book.author);
        assertEquals(2007, book.year);
    }

    @Test
    public void shouldHaveStatus() {
        Book book = new Book("Head First Java", "J. Rollings", 2007);
        assertEquals(true, book.isAvailable());
    }
}
