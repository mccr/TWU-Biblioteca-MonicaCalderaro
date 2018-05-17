package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void shouldHaveANameDirectorYearAndRating() {
        Movie movie = new Movie("Butterfly Effect", "Steven Spilberg", 2000, 10);

        assertEquals("Butterfly Effect", movie.name);
        assertEquals("Steven Spilberg", movie.director);
        assertEquals(2000, movie.year);
        assertEquals(10, movie.rating);
    }
}