//package com.twu.biblioteca;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class BookListTest {
//    ArrayList<Book> libraryBooks;
//
//    @Before
//    public void setUp() throws Exception {
//        libraryBooks = BookList.getBooks();
//    }
//
//    @Test
//    public void shouldHaveAListOfBooks() {
//
//        assertEquals(6, libraryBooks.size());
//    }
//
//    @Test
//    public void shouldReturnTheStatusOfABook() {
//
//        assertEquals(true, libraryBooks.get(0).isAvailable);
//    }
//
//
//}
