package org.example.sorted_book;

import org.example.model.Book;

import java.util.Comparator;

// Сортировка по автору
public class ComparatorByAuthor implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return compareToByAuthor(book1,book2);
    }

    public int compareToByAuthor(Book book1, Book book2) {
        return CharSequence.compare(book1.getAuthor(), book2.getAuthor());
    }
}
