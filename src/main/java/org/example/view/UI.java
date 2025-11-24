package org.example.view;

import org.example.controller.AccessUser;
import org.example.controller.LibraryUser;
import org.example.file.FileSerializable;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

public class UI {

    Scanner scanner;
    LibraryUser libraryUser;
    FileSerializable fileSerializable;

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    // Инициализация переменных
    public void init() throws IOException {
        scanner = new Scanner(in);
        libraryUser = new LibraryUser(AccessUser.ADMIN);
        fileSerializable = new FileSerializable();
        libraryUser.setBooks(fileSerializable.importBooks(libraryUser.getBooks()));
    }

}
