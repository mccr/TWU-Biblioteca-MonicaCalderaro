package com.twu.biblioteca;

abstract class LibraryItem {
    int year;
    private boolean isAvailable = true;
    String type;

    public LibraryItem(String libraryItem) {
        this.type = libraryItem;
    }

    public void updateAvailability() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            isAvailable = true;
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
