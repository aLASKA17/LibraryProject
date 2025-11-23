package org.example.view;


import org.example.exception.NotMenuPointException;

import java.util.InputMismatchException;

import static java.lang.System.*;

public class UIUser {

    // Меню для пользователя
    public void uiUser(UI ui) {
        int chooseUserMenu = 0;
        UIFunction uiFunction = new UIFunction();
        do {
            out.println("Меню");
            out.println("1) Вывод книг");
            out.println("2) Поиск");
            out.println("3) Сортировать книгу");
            out.println("4) Выход");
            out.print("Выберите действие: ");
            try {
                chooseUserMenu = ui.scanner.nextInt();
                if (chooseUserMenu < 1 || chooseUserMenu > 4){
                    throw  new NotMenuPointException("Данного пункта нет в меню");
                }
                switch (chooseUserMenu) {
                    case 1: {
                        ui.libraryUser.displayBooks();
                        break;
                    }
                    case 2: {
                        uiFunction.searchBookUIMenu(ui);
                        break;
                    }
                    case 3: {
                        uiFunction.sortBookUIMenu(ui);
                        break;
                    }
                    case 4: {
                        exit(0);
                    }
                }
            } catch(InputMismatchException ex){
                out.println("Неккоретно введенно значение в меню!");
                ui.scanner.nextLine();
            } catch (NotMenuPointException ex) {
                out.println(ex.getMessage());
            }
        } while (chooseUserMenu != 4);
    }
}
