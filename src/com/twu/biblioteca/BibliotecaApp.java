package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        library.welcomeMessage();
    }

    public void welcomeMessage() {
        System.out.println("welcome user");
    }


    public void mainMenu() {
        System.out.println("Welcome to the main menu \n1.Book List\n2.Quit");
    }
}
