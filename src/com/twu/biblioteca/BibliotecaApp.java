package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    Librarian librarian;

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        library.librarian = new Librarian();
        library.welcomeMessage();
        library.mainMenu();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the main menu, choose an option:");
    }


    public void mainMenu() {
        String menu = "1.Book List\n2.Quit\n3.Checkout Book\n4.Return";
        System.out.println(menu);

        String option = this.inputUser();

        switch (Integer.parseInt(option)) {
            case 1:

                for (Book book : librarian.getBooks()) {
                    if (book.isAvailable == true) System.out.println(book.title);
                }
                break;

            case 2:
                System.out.println("You just Quit, GoodBye");
                break;

            case 3:
                System.out.println("Thank you! Enjoy the book");
                break;

            default:
                System.out.println("Select a valid option!");
                this.mainMenu();
                break;
        }
    }

    public String inputUser() {
        System.out.println("Choose your option: ");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        System.out.println("you choose: " + option);
        return option;
    }
}
