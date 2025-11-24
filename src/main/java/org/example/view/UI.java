package org.example.view;

import org.example.controller.AccessUser;
import org.example.controller.LibraryUser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import static java.lang.System.in;

public class UI {

    Scanner scanner;

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    LibraryUser libraryUser;

    // Инициализация переменных
    public void init() throws IOException {
        scanner = new Scanner(in);
        libraryUser = new LibraryUser(AccessUser.ADMIN);
    }

}
