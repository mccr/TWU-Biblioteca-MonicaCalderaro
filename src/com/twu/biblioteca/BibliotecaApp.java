package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        System.out.println(library.welcomeMessage());
    }

    public String welcomeMessage() {
        return "welcome user";
    }


    public void mainMenu() {
        System.out.println("Welcome to the main menu \n1.Book List\n2.Quit");
    }
}
