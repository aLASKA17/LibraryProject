package org.example.view;

import org.example.exception.NotMenuPointException;

import java.io.IOException;
import java.util.InputMismatchException;

import static java.lang.System.*;

public class UIAdmin {

    // Меню для админа
    public void uiAdmin(UI ui) throws IOException {
        UIFunction uiFunction = new UIFunction();
        int chooseAdminMenu = 0;
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
                try {
                    chooseAdminMenu = ui.scanner.nextInt();
                    if (chooseAdminMenu < 1 || chooseAdminMenu > 7) {
                        throw new NotMenuPointException("Данного пункта нет в меню");
                    }
                    switch (chooseAdminMenu) {
                        case 1: {
                            Thread threadAdd = new Thread(() -> {
                                uiFunction.addBookUIMenu(ui);
                            });
                            threadAdd.start();
                            break;
                        }
                        case 2: {
                            uiFunction.editBookUIMenu(ui);
                            break;
                        }
                        case 3: {
                            uiFunction.removeBookUIMenu(ui);
                            break;
                        }
                        case 4: {
                            ui.libraryUser.displayBooks();
                            break;
                        }
                        case 5: {
                            uiFunction.searchBookUIMenu(ui);
                            break;
                        }
                        case 6: {
                            uiFunction.sortBookUIMenu(ui);
                           break;
                        }
                        case 7: {
                            exit(0);
                        }
                    }
                } catch (InputMismatchException ex) {
                    out.println("Неккоретно введенно значение в меню!");
                    ui.scanner.nextLine();
                } catch (NotMenuPointException ex) {
                    out.println(ex.getMessage());
                }
        } while (chooseAdminMenu != 7);
    }
}
