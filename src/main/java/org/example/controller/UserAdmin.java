package org.example.controller;

import org.example.model.Book;


public interface UserAdmin {
    void addBook(Book book);
    void editAuthorBook(int idBook, String author);
    void editTitleBook(int idBook, String title);
    void editPriceBook(int idBook, double price);
    void removeBook(int idBook);
}
