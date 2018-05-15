package com.twu.biblioteca;

import java.util.ArrayList;
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


    public void mainMenu() {
        String menu = "1.Book List\n2.Quit\n3.Checkout Book\n4.Return";
        System.out.println(menu);

        String option = this.inputUser();

        switch (Integer.parseInt(option)) {
            case 1:
                String result = "";
                BookList bookList = new BookList();
                ArrayList<Book> booksAvailable = bookList.getBooks();
                for (Book book : booksAvailable) {
                    if (book.isAvailable == true) System.out.println(book.title);
                }
                System.out.println(result);
                break;

            case 2:
                System.out.println("You just Quit, GoodBye");
                break;

            case 3:

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
