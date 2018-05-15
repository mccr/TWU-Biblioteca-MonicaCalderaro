package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class BibliotecaAppTest {
    BibliotecaApp app;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public void inputMock(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() {
        app = new BibliotecaApp(new Librarian());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldReturnAWelcomeMessage() {
        app.welcomeMessage();
        assertEquals("Welcome to the main menu, choose an option:", outContent.toString().trim());
    }

    @Test
    public void shouldPrintAMainMenuOptions() {
        String message = "1.Book List\n2.Quit\n3.Checkout Book\n4.Return";

        this.inputMock("2");

        app.mainMenu();

        assertThat(outContent.toString().trim(), CoreMatchers.containsString(message));
    }

    @Test
    public void shouldReceiveInputFromUser() {
        this.inputMock("1");

        app.inputUser();

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Choose your option: "));
        assertThat(outContent.toString().trim(), CoreMatchers.containsString("you choose: 1"));
    }

    @Test
    public void shouldPrintAListOfBooksAvailables() {
        String result = "book\nbook\nbook\nbook\nbook\nbook";

        app.chooseOptions("1");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString(result));
    }

    @Test
    public void shouldDetectInvalidOption() {
        app.chooseOptions("6");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Select a valid option!"));
    }

    @Test
    public void shouldBeAbleToQuit() {
        this.inputMock("2");

        app.mainMenu();

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("You just Quit, GoodBye"));
    }

    @Test
    public void shouldBeAbleToCheckOutABook() {
        app.chooseOptions("3");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldBeAbleToReturnABook() {
        app.chooseOptions("4");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Thank you for returning the book."));
    }
}
