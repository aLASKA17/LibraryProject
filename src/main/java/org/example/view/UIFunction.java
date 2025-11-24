package org.example.view;

import org.example.exception.NotMenuPointException;
import org.example.file.FileSerializable;
import org.example.model.Book;
import org.example.sorted_book.ComparatorByAuthor;
import org.example.sorted_book.ComparatorByPrice;
import org.example.sorted_book.ComparatorByTitle;

import java.util.InputMismatchException;

import static java.lang.System.*;

public class UIFunction {

    private FileSerializable fileSerializable = new FileSerializable();

    // Меню для добавления книги
    public void addBookUIMenu(UI ui){
        ui.scanner.nextLine();
        out.print("Введите название книги: ");
        String title = ui.scanner.nextLine();
        out.print("Введите автора книги: ");
        String author = ui.scanner.nextLine();
        double price = 0;
        do {
            try {
                out.print("Введите цену книги: ");
                price = ui.scanner.nextDouble();
            } catch (InputMismatchException ex) {
                out.println("Неккоретно введенно значение!");
                ui.scanner.nextLine();
            }
        } while (price == 0);
        ui.libraryUser.addBook(new Book(title, author, price));
        ui.libraryUser.updateIndex();
        fileSerializable.saveBooks(ui.libraryUser.getBooks());
    }

    // Меню для измения книг
    public void editBookUIMenu(UI ui) throws  NotMenuPointException {
        int chooseEditMenu = 0;
            out.println("Меню изменения");
            out.println("1) Изменить название книги");
            out.println("2) Изменить автора книги");
            out.println("3) Изменить цену книги");
            try {
                out.print("Выберите действие: ");
                chooseEditMenu = ui.scanner.nextInt();
                if (chooseEditMenu < 1 || chooseEditMenu > 3) {
                    throw new NotMenuPointException("Данного пункта нет в меню");
                }
                switch (chooseEditMenu) {
                    case 1: {
                        ui.libraryUser.displayBooks();
                        int editId = 0;
                        do {
                            try {
                                out.print("Введите id книги, котороую хотите изменить: ");
                                editId = ui.scanner.nextInt() - 1;
                            } catch (InputMismatchException ex) {
                                out.println("Неккоретно введенно значение!");
                                ui.scanner.nextLine();
                            }
                        } while (editId == 0);
                        out.print("\nВведите название книги: ");
                        String title = ui.scanner.nextLine();
                        ui.libraryUser.editTitleBook(editId, title);
                        ui.libraryUser.updateIndex();
                        fileSerializable.saveBooks(ui.libraryUser.getBooks());
                        break;
                    }
                    case 2: {
                        ui.libraryUser.displayBooks();
                        int editId = 0;
                        do {
                            try {
                                out.print("Введите id книги, котороую хотите изменить: ");
                                editId = ui.scanner.nextInt() - 1;
                            } catch (InputMismatchException ex) {
                                out.println("Неккоретно введенно значение!");
                                ui.scanner.nextLine();
                            }
                        } while (editId == 0);
                        out.print("\nВведите автора книги: ");
                        String author = ui.scanner.nextLine();
                        ui.libraryUser.editAuthorBook(editId, author);
                        ui.libraryUser.updateIndex();
                        fileSerializable.saveBooks(ui.libraryUser.getBooks());
                        break;
                    }
                    case 3: {
                        ui.libraryUser.displayBooks();
                        int editId = 0;
                        do {
                            try {
                                out.print("Введите id книги, котороую хотите изменить: ");
                                editId = ui.scanner.nextInt() - 1;
                            } catch (InputMismatchException ex) {
                                out.println("Неккоретно введенно значение!");
                                ui.scanner.nextLine();
                            }
                        } while (editId == 0);
                        out.print("\nВведите цену книги: ");
                        double price = ui.scanner.nextDouble();
                        ui.libraryUser.editPriceBook(editId, price);
                        ui.libraryUser.updateIndex();
                        fileSerializable.saveBooks(ui.libraryUser.getBooks());
                        break;
                    }
                }
            } catch (InputMismatchException ex) {
                out.println("Неккоретно введенно значение в меню!");
                ui.scanner.nextLine();
            }
            catch (NotMenuPointException ex) {
                out.println(ex.getMessage());
            }
    }

    // Меню для удаления книг
    public void removeBookUIMenu(UI ui) {
        ui.libraryUser.displayBooks();
        int removeId = 0;
        do {
            try {
                out.print("Введите id книги, ктороую хотите удалить: ");
                removeId = ui.scanner.nextInt();
                ui.libraryUser.removeBook(removeId-1);
                ui.libraryUser.updateIndex();
                fileSerializable.saveBooks(ui.libraryUser.getBooks());
            } catch (InputMismatchException ex) {
                out.println("Неккоретно введенно значение!");
                ui.scanner.nextLine();
            } catch (IndexOutOfBoundsException ex) {
                out.println("Книги по данному индексу нет!");
                ui.scanner.nextLine();
            }
        } while (removeId == 0);
    }

    // Меню для поиска книги
    public void searchBookUIMenu(UI ui) {
        int chooseSearchMenu = 0;
        out.println("Меню изменения");
        out.println("1) Поиск по названию книги");
        out.println("2) Поиск по автору книги");
        try {
            out.print("Выберите действие: ");
            chooseSearchMenu = ui.scanner.nextInt();
            if (chooseSearchMenu < 1 || chooseSearchMenu > 2) {
                throw new NotMenuPointException("Данного пункта нет в меню");
            }
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
            }
        } catch (InputMismatchException ex) {
            out.println("Неккоретно введенно значение в меню!");
            ui.scanner.nextLine();
        }
        catch (NotMenuPointException ex) {
            out.println(ex.getMessage());
        }
    }

    // Меню для сортировки книг
    public void sortBookUIMenu(UI ui) {
        int chooseSortMenu;
            out.println("Меню сортировки");
            out.println("1) Сортировать по названию книги");
            out.println("2) Сортировать по автору книги");
            out.println("3) Сортировать по цене книги");
            try {
                out.print("Выберите действие: ");
                chooseSortMenu = ui.scanner.nextInt();
                if (chooseSortMenu < 1 || chooseSortMenu > 3) {
                    throw new NotMenuPointException("Данного пункта нет в меню");
                }
                switch (chooseSortMenu) {
                    case 1: {
                        out.println("1) Сортировать по возрастанию");
                        out.println("2) Сортировать по убыванию");
                        try {
                            out.print("Сортировать по: ");
                            int chooseSortTitle = ui.scanner.nextInt();
                            if (chooseSortTitle < 1 || chooseSortTitle > 2) {
                                throw new NotMenuPointException("Данного пункта нет в меню");
                            }
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
                        } catch (InputMismatchException ex) {
                            out.println("Неккоретно введенно значение в меню!");
                            ui.scanner.nextLine();
                        }
                        catch (NotMenuPointException ex) {
                            out.println(ex.getMessage());
                        }
                    }
                    case 2: {
                        out.println("1) Сортировать по возрастанию");
                        out.println("2) Сортировать по убыванию");
                        try {
                            out.print("Сортировать по: ");
                            int chooseSortAuthor = ui.scanner.nextInt();
                            if (chooseSortAuthor < 1 || chooseSortAuthor > 2) {
                                throw new NotMenuPointException("Данного пункта нет в меню");
                            }
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
                        } catch (InputMismatchException ex) {
                            out.println("Неккоретно введенно значение в меню!");
                            ui.scanner.nextLine();
                        }
                        catch (NotMenuPointException ex) {
                            out.println(ex.getMessage());
                        }
                    }
                    case 3: {
                        out.println("1) Сортировать по возрастанию");
                        out.println("2) Сортировать по убыванию");
                        try {
                            out.print("Сортировать по: ");
                            int chooseSortPrice = ui.scanner.nextInt();
                            if (chooseSortPrice < 1 || chooseSortPrice > 2) {
                                throw new NotMenuPointException("Данного пункта нет в меню");
                            }
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
                        } catch (InputMismatchException ex) {
                            out.println("Неккоретно введенно значение в меню!");
                            ui.scanner.nextLine();
                        }
                        catch (NotMenuPointException ex) {
                            out.println(ex.getMessage());
                        }
                    }
                }
            } catch (InputMismatchException ex) {
                out.println("Неккоретно введенно значение в меню!");
                ui.scanner.nextLine();
            }
            catch (NotMenuPointException ex) {
                out.println(ex.getMessage());
            }
    }
}
