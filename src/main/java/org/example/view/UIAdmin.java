package org.example.view;

import org.example.model.Book;
import org.example.sorted_book.ComparatorByAuthor;
import org.example.sorted_book.ComparatorByPrice;
import org.example.sorted_book.ComparatorByTitle;


import java.io.IOException;

import static java.lang.System.*;

public class UIAdmin {

    // Меню для админа
    public void uiAdmin(UI ui) throws IOException {
        int chooseAdminMenu;
        do {
            out.println("Меню");
            out.println("1) Добавить книгу");
            out.println("2) Изменить книгу");
            out.println("3) Удалить книгу");
            out.println("4) Вывод книг");
            out.println("5) Поиск");
            out.println("6) Сортировать книгу");
            out.println("7) Выход");
            out.print("Выберите действие: ");
            chooseAdminMenu = ui.scanner.nextInt();
            switch (chooseAdminMenu) {
                case 1: {
                    ui.scanner.nextLine();
                    out.print("Введите название книги: ");
                    String title = ui.scanner.nextLine();
                    out.print("Введите автора книги: ");
                    String author = ui.scanner.nextLine();
                    out.print("Введите цену книги: ");
                    double price = ui.scanner.nextDouble();
                    ui.libraryUser.addBook(new Book(title, author, price));
                    ui.objectOutputStream.writeObject(ui.libraryUser);
                    ui.objectOutputStream.close();
                    break;
                }
                case 2: {
                    int chooseEditMenu;
                    do {
                        out.println("Меню изменения");
                        out.println("1) Изменить название книги");
                        out.println("2) Изменить автора книги");
                        out.println("3) Изменить цену книги");
                        out.println("4) Выход");
                        out.print("Выберите действие: ");
                        chooseEditMenu = ui.scanner.nextInt();
                        switch (chooseEditMenu) {
                            case 1: {
                                ui.libraryUser.displayBooks();
                                out.print("Введите id книги, котороую хотите изменить: ");
                                int editId = ui.scanner.nextInt()-1;
                                ui.scanner.nextLine();
                                out.print("\nВведите название книги: ");
                                String title = ui.scanner.nextLine();
                                ui.libraryUser.editTitleBook(editId, title);
                                break;
                            }
                            case 2: {
                                ui.libraryUser.displayBooks();
                                out.print("Введите id книги, котороую хотите изменить: ");
                                int editId = ui.scanner.nextInt()-1;
                                ui.scanner.nextLine();
                                out.print("\nВведите автора книги: ");
                                String author = ui.scanner.nextLine();
                                ui.libraryUser.editAuthorBook(editId, author);
                                break;
                            }
                            case 3: {
                                ui.libraryUser.displayBooks();
                                out.print("Введите id книги, котороую хотите изменить: ");
                                int editId = ui.scanner.nextInt()-1;
                                ui.scanner.nextLine();
                                out.print("\nВведите цену книги: ");
                                double price = ui.scanner.nextDouble();
                                ui.libraryUser.editPriceBook(editId,price);
                                break;
                            }
                            case 4: {
                                uiAdmin(ui);
                                chooseAdminMenu = 0;
                                break;
                            }
                        }
                    } while (chooseEditMenu != 4);
                }
                case 3: {
                    ui.libraryUser.displayBooks();
                    out.print("Введите id книги, ктороую хотите удалить: ");
                    int removeId = ui.scanner.nextInt();
                    ui.libraryUser.removeBook(removeId);
                    break;
                }
                case 4: {
                    ui.libraryUser.displayBooks();
                    break;
                }
                case 5: {
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
                            uiAdmin(ui);
                            chooseAdminMenu = 0;
                            break;
                        }
                    }
                }
                case 6: {
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
                                uiAdmin(ui);
                                chooseAdminMenu = 0;
                                break;
                            }
                        }
                    } while (chooseSortMenu != 4);
                }
                case 7: {
                    exit(0);
                }
            }
        } while (chooseAdminMenu != 7);
    }
}
