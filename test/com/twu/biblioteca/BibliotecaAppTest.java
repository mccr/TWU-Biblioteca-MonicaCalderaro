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
        app = new BibliotecaApp();
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
        String message = "1.Book List\n2.Quit\n3.Checkout Book\n4.Return Book\n5.Movie List\n6.Checkout Movie\n7.Return Movie";

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

//    @Test
//    public void shouldPrintAListOfBooksAvailables() {
//        String result = "Head First Java\nClean Code\nDesign Pattern\nJavaScript\nScala Workshop\nRoR Design";
//
//        app.chooseOptions("1");
//
//        assertThat(outContent.toString().trim(), CoreMatchers.containsString(result));
//    }

    @Test
    public void shouldDetectInvalidOption() {
        app.chooseOptions("10");

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
        this.inputMock("Head First Java");

        app.chooseOptions("3");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldBeAbleToReturnABook() {
        this.inputMock("Head First Java");

        app.librarian.bookList.get(0).updateAvailability();

        app.chooseOptions("4");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Thank you for returning the book"));
    }

//    @Test
//    public void shouldPrintAListOfMovies() {
//        this.inputMock("5");
//
//        String movies = "movie\nmovie\nmovie";
//
//        app.chooseOptions("5");
//
//        assertThat(outContent.toString().trim(), CoreMatchers.containsString(movies));
//    }


    @Test
    public void shouldBeAbleToCheckoutMovie() {
        this.inputMock("Butterfly Effect");

        app.chooseOptions("6");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Thank you! Enjoy the movie"));

    }

    @Test
    public void shouldBeAbleToReturnAMovie() {
        this.inputMock("Butterfly Effect");

        app.librarian.movieList.get(0).updateAvailability();

        app.chooseOptions("7");

        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Thank you for returning the movie"));
    }
}
