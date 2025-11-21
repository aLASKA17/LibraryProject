package org.example.controller;

import org.example.model.Book;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class LibraryUser implements UserAdmin, UserRegular, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public ArrayList<Book> getBooks() {
        return books;
    }

    public LibraryUser(AccessUser accessUser) {
        this.accessUser = accessUser;
    }

    public AccessUser getAccessUser() {
        return accessUser;
    }

    public void setAccessUser(AccessUser accessUser) {
        this.accessUser = accessUser;
    }

    private AccessUser accessUser;
    ArrayList<Book> books = new ArrayList<>();

    // Вывод всех книг
    @Override
    public void displayBooks() {
        books.forEach(book -> {
            System.out.println(book.toString());
        });
    }

    // Поиск по названию
    @Override
    public void searchBookByTitle(String title) {
        books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).forEach(book -> {
            System.out.println(book.toString());
        });
    }

    // Поиск по автору
    @Override
    public void searchBookByAuthor(String author) {
        books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).forEach(book -> {
            System.out.println(book.toString());
        });
    }

    // Добавление новой книги
    @Override
    public void addBook(Book book) {
        if (accessUser == AccessUser.ADMIN) {
            books.add(book);
        } else {
            System.out.println("Нет доступа");
        }
    }

    // Изменение автора книги
    @Override
    public void editAuthorBook(int idBook, String author) {
        if (accessUser == AccessUser.ADMIN) {
            books.get(idBook).setAuthor(author);
        } else {
            System.out.println("Нет доступа");
        }
    }

    // Изменение названия книги
    @Override
    public void editTitleBook(int idBook, String title) {
        if (accessUser == AccessUser.ADMIN) {
            books.get(idBook).setTitle(title);
        } else {
            System.out.println("Нет доступа");
        }
    }

    // Изменение цены книги
    @Override
    public void editPriceBook(int idBook, double price) {
        if (accessUser == AccessUser.ADMIN) {
            books.get(idBook).setPrice(price);
        } else {
            System.out.println("Нет доступа");
        }
    }

    // Удалить книгу
    @Override
    public void removeBook(int idBook) {
        if (accessUser == AccessUser.ADMIN) {
            books.remove(idBook);
        } else {
            System.out.println("Нет доступа");
        }
    }
}
