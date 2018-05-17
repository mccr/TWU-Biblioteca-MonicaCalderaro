package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    Librarian librarian = new Librarian();


    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp();
        library.welcomeMessage();
        library.mainMenu();
    }

    public void welcomeMessage() {
        this.printMessage("Welcome to the main menu, choose an option:");
    }


    public void mainMenu() {
        boolean isActive = true;
        String menu = "1.Book List\n2.Quit\n3.Checkout Book\n4.Return Book\n5.Movie List";

        while (isActive) {
            this.printMessage(menu);

            String option = this.inputUser();
            this.chooseOptions(option);

            if (option.equals("2")) {
                isActive = false;
            }
        }

    }

    public String inputUser() {
        this.printMessage("Choose your option: ");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        this.printMessage("you choose: " + option);
        return option;
    }

    public void printBookList() {
        System.out.format("%15s%15s%15s\n", "Book Title", "Book Author", "Year Pub.");
        for (Book book : librarian.bookList) {
            if (book.isAvailable) {
                System.out.format("%15s%15s%15s\n", book.title, book.author, book.year);
            }
        }
    }


    public void chooseOptions(String choice) {
        Book userBook;

        switch (Integer.parseInt(choice)) {
            case 1:
                this.printBookList();
                break;

            case 2:
                this.printMessage("You just Quit, GoodBye");
                break;

            case 3:
                userBook = librarian.checkList(this.inputUser());
                librarian.checkout(userBook);
                break;

            case 4:
                userBook = librarian.checkList(this.inputUser());
                librarian.returns(userBook);
                break;

            default:
                this.printMessage("Select a valid option!");
                break;
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
