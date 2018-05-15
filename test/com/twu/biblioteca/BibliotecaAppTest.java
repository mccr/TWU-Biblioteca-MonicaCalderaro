package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private OutputStream prepareRedirectOutputForTests(){

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
        return outputStream;
    }

    @Test
    public void shouldReturnAWelcomeMessage() {
        // Given
        BibliotecaApp app = new BibliotecaApp();
        // When
        String outputMessage = app.welcomeMessage();
        // Then
        assertEquals("welcome user", outputMessage);
    }

    @Test
    public void shouldPrintAMainMenuOptions() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaApp app = new BibliotecaApp();
        String message = "Welcome to the main menu \n1.Book List\n2.Quit";
        app.mainMenu();
        assertEquals(message, outputStream.toString().trim());
    }
}
