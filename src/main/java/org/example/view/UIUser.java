package org.example.view;

import org.example.sorted_book.ComparatorByAuthor;
import org.example.sorted_book.ComparatorByPrice;
import org.example.sorted_book.ComparatorByTitle;

import static java.lang.System.*;

public class UIUser {

    // Меню для пользователя
    public void uiUser(UI ui) {
        int chooseUserMenu;

        do {
            out.println("Меню");
            out.println("1) Вывод книг");
            out.println("2) Поиск");
            out.println("3) Сортировать книгу");
            out.println("4) Выход");
            out.print("Выберите действие: ");
            chooseUserMenu = ui.scanner.nextInt();
            switch (chooseUserMenu) {
                case 1: {
                    ui.libraryUser.displayBooks();
                    break;
                }
                case 2: {
                    int chooseSearchMenu;
                    out.println("Меню изменения");
                    out.println("1) Поиск по названию книги");
                    out.println("2) Поиск по автору книги");
                    out.println("3) Выход");
                    out.print("Выберите действие: ");
                    chooseSearchMenu = ui.scanner.nextInt();
                    switch (chooseSearchMenu) {
                        case 1: {
                            out.print("Введите название книги, по которой хотите произвести поиск: ");
                            ui.scanner.nextLine();
                            String title = ui.scanner.nextLine();
                            ui.libraryUser.searchBookByTitle(title);
                            break;
                        }
                        case 2: {
                            out.print("Введите автора книги, по которой хотите произвести поиск: ");
                            ui.scanner.nextLine();
                            String author = ui.scanner.nextLine();
                            ui.libraryUser.searchBookByAuthor(author);
                            break;
                        }
                        case 3: {
                            uiUser(ui);
                            chooseUserMenu = 0;
                            break;
                        }
                    }
                }
                case 3: {
                    int chooseSortMenu;
                    do {
                        out.println("Меню сортировки");
                        out.println("1) Сортировать по названию книги");
                        out.println("2) Сортировать по автору книги");
                        out.println("3) Сортировать по цене книги");
                        out.println("4) Выход");
                        out.print("Выберите действие: ");
                        chooseSortMenu = ui.scanner.nextInt();
                        switch (chooseSortMenu) {
                            case 1: {
                                out.println("1) Сортировать по возрастанию");
                                out.println("2) Сортировать по убыванию");
                                out.print("Сортировать по: ");
                                int chooseSortTitle = ui.scanner.nextInt();
                                switch (chooseSortTitle) {
                                    case 1: {
                                        ui.libraryUser.getBooks().sort(new ComparatorByTitle());
                                        break;
                                    }
                                    case 2: {
                                        ui.libraryUser.getBooks().sort(new ComparatorByTitle().reversed());
                                        break;
                                    }
                                }
                            }
                            case 2: {
                                out.println("1) Сортировать по возрастанию");
                                out.println("2) Сортировать по убыванию");
                                out.print("Сортировать по: ");
                                int chooseSortAuthor = ui.scanner.nextInt();
                                switch (chooseSortAuthor) {
                                    case 1: {
                                        ui.libraryUser.getBooks().sort(new ComparatorByAuthor());
                                        break;
                                    }
                                    case 2: {
                                        ui.libraryUser.getBooks().sort(new ComparatorByAuthor().reversed());
                                        break;
                                    }
                                }
                            }
                            case 3: {
                                out.println("1) Сортировать по возрастанию");
                                out.println("2) Сортировать по убыванию");
                                out.print("Сортировать по: ");
                                int chooseSortPrice = ui.scanner.nextInt();
                                switch (chooseSortPrice) {
                                    case 1: {
                                        ui.libraryUser.getBooks().sort(new ComparatorByPrice());
                                        break;
                                    }
                                    case 2: {
                                        ui.libraryUser.getBooks().sort(new ComparatorByPrice().reversed());
                                        break;
                                    }
                                }
                            }
                            case 4: {
                                uiUser(ui);
                                chooseUserMenu = 0;
                                break;
                            }
                        }
                    } while (chooseSortMenu != 4);
                }
                case 4: {
                    exit(0);
                }
            }
        } while (chooseUserMenu != 4);




    }
}
