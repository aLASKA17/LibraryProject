package org.example;

import org.example.view.UI;
import org.example.view.UIAdmin;
import org.example.view.UIUser;

import static java.lang.System.*;


public class App {

    UI ui;
    UIAdmin uiAdmin;
    UIUser uiUser;

    // Инициализация меню
    public void init() {
        ui = new UI();
        uiAdmin = new UIAdmin();
        uiUser = new UIUser();
        ui.init();
    }

    // Запуск приложения
    public void run() {
        init();
        switch (ui.getLibraryUser().getAccessUser()) {
            case USER -> uiUser.uiUser(ui);
            case ADMIN -> uiAdmin.uiAdmin(ui);
        }
    }





}
