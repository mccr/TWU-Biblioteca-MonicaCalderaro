package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private Librarian librarian;
    private ArrayList<Book> booksAvailable = Librarian.getBooks();

    public BibliotecaApp(Librarian librarian) {
        this.librarian = librarian;
    }

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp(new Librarian());
        library.welcomeMessage();
        library.mainMenu();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the main menu, choose an option:");
    }


    public void mainMenu() {
        boolean isAlive = true;
        String menu = "1.Book List\n2.Quit\n3.Checkout Book\n4.Return";

        while (isAlive) {
            System.out.println(menu);
            String option = this.inputUser();
            this.chooseOptions(option);
            if (option.equals("2")) {
                isAlive = false;
            }
        }

    }

    public String inputUser() {
        System.out.println("Choose your option: ");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        System.out.println("you choose: " + option);
        return option;
    }

    public void chooseOptions(String choice) {
        switch (Integer.parseInt(choice)) {
            case 1:

                for (Book book : booksAvailable) {
                    if (book.isAvailable) System.out.println(book.title);
                }
                break;

            case 2:
                System.out.println("You just Quit, GoodBye");
                break;

            case 3:
                librarian.checkout(booksAvailable.get(0));
                break;

            case 4:
                librarian.returns(booksAvailable.get(0));
                break;

            default:
                System.out.println("Select a valid option!");
                break;
        }
        System.out.println(booksAvailable.get(0).isAvailable);
    }
}
