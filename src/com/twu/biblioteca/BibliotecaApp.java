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
        String menu = "1.Book List\n2.Quit";
        System.out.println(menu);

        String option = this.inputUser();

        switch (Integer.parseInt(option)) {
            case 1:
                String result = "";
                BookList bookList = new BookList();
                ArrayList<Book> booksAvailable = bookList.getBooks();
                for (int i = 0; i < booksAvailable.size(); i++) {
                    if (i == 0) {
                        result = booksAvailable.get(0).title;
                    } else {
                        result += "\n"+booksAvailable.get(i).title;
                    }
                }
                System.out.println(result);
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
