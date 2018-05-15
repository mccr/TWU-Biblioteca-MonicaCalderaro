package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        library.welcomeMessage();
        library.mainMenu();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the main menu, choose an option:");
    }


    public String mainMenu() {
        System.out.println("1.Book List\n2.Quit");
        String option = this.inputUser();
        return option;
    }

    public String inputUser() {
        System.out.println("Choose your option: ");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        System.out.println("you choose: " + option);
        return option;
    }
}
