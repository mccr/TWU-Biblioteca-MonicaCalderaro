package com.twu.biblioteca;

import java.util.ArrayList;

public class Librarian {
    ArrayList<Movie> movieList;
    ArrayList<Book> bookList;

    public Librarian() {
        this.bookList = this.getBooks();
        this.movieList = this.getMovies();
    }

    public ArrayList<Book> getBooks() {
        bookList = new ArrayList<Book>();
        for (int i = 0; i < 6; i++) {
            bookList.add(new Book("book", "author", 2000));
        }

        String[] titles = {"Head First Java", "CLean Code", "Design Pattern", "JavaScript", "Scala Workshop", "RoR Design"};
        String[] authors = {"JK Rolling", "KK Rachel", "Denis Newton", "Marc Jacobs", "Laurie Moore", "Jesus Manch"};
        int[] years = {2000, 1990, 2004, 2018, 1989, 2002};

        for (int i = 0; i < bookList.size(); i++) {
            bookList.get(i).title = titles[i];
            bookList.get(i).author = authors[i];
            bookList.get(i).year = years[i];
        }

        return bookList;
    }

    public ArrayList<Movie> getMovies() {
        movieList = new ArrayList<Movie>();
        for (int i = 0; i < 3; i++) {
            movieList.add(new Movie("Butterfly Effect", "Steven Spilberg", 2000, 10));
        }

        String[] names = {"Butterfly Effect", "Irreversible", "Carne"};
        String[] directors = {"Steven Spilberg", "Gaspar Noe", "Gaspar Noe"};
        int[] years = {2000, 1990, 2004};
        int[] ratings = {10, 5, 7};

        for (int i = 0; i < movieList.size(); i++) {
            movieList.get(i).name = names[i];
            movieList.get(i).director = directors[i];
            movieList.get(i).year = years[i];
            movieList.get(i).rating = ratings[i];
        }
        return movieList;
    }

    public LibraryItem checkList(String inputUser, String libraryItem) {
        LibraryItem item = null;
        if (libraryItem == "book") {
            for (Book bookAvailable : bookList) {
                if (inputUser.equals(bookAvailable.title)) item = bookAvailable;
            }
        } else {
            for (Movie movieAvailable : movieList) {
                if (inputUser.equals(movieAvailable.name)) item = movieAvailable;
            }
        }
        return item;
    }

    public void checkout(LibraryItem item) {
        if (item != null && item.isAvailable()) {
            item.updateAvailability();
            this.printMessage("Thank you! Enjoy the " + item.type);
        } else {
            this.printMessage("That item is not available.");
        }
    }

    public void returns(LibraryItem item) {
        if (item != null && !item.isAvailable()) {
            item.updateAvailability();
            this.printMessage("Thank you for returning the " + item.type);
        } else {
            this.printMessage("That is not a valid item to return.");
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
