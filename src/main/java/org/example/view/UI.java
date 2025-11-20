package org.example.view;

import org.example.controller.AccessUser;
import org.example.controller.LibraryUser;

import java.util.Scanner;

import static java.lang.System.in;

public class UI {

    Scanner scanner;

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    LibraryUser libraryUser;

    // Инициализация переменных
    public void init() {
        scanner = new Scanner(in);
        libraryUser = new LibraryUser(AccessUser.ADMIN);
    }

}
