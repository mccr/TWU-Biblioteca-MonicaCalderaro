package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {
    BibliotecaApp app;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnAWelcomeMessage() {
        app.welcomeMessage();
        assertEquals("welcome user", outContent.toString().trim());
    }

    @Test
    public void shouldPrintAMainMenuOptions() {
        String message = "Welcome to the main menu \n1.Book List\n2.Quit";
        app.mainMenu();
        assertEquals(message, outContent.toString().trim());
    }
}
