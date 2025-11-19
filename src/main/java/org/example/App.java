package org.example;

import org.example.controller.AccessUser;
import org.example.controller.LibraryUser;
import static java.lang.System.*;

import java.util.Scanner;

public class App {

    Scanner scanner;
    LibraryUser libraryUser;

    // Инициализация переменных
    public void init() {
        scanner = new Scanner(in);
        libraryUser = new LibraryUser(AccessUser.ADMIN);
    }

    // Запуск приложения
    public void run() {
        init();
        switch (libraryUser.getAccessUser()) {
            case USER -> uiUser();
            case ADMIN -> uiAdmin();
        }
    }

    // Меню для админа
    public void uiAdmin() {
        out.println("Меню");
        out.println("1) Добавить книгу");
        out.println("2) Изменить книгу");
        out.println("3) Удалить книгу");
        out.println("4) Вывод книги");
        out.println("5) Поиск");
        out.println("6) Сортировать книгу");
        out.println("7) Выход");
    }

    // Меню для пользователя
    public void uiUser() {
        out.println("Меню");
        out.println("1) Вывод книги");
        out.println("2) Поиск");
        out.println("3) Сортировать книгу");
        out.println("4) Выход");
    }
}
