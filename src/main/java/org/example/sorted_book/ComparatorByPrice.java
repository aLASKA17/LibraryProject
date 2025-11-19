package org.example.sorted_book;

import org.example.model.Book;

import java.util.Comparator;

// Сортировка по цене
public class ComparatorByPrice implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return compareToByPrice(book1,book2);
    }

    public int compareToByPrice(Book book1, Book book2) {
        return Double.compare(book1.getPrice(), book2.getPrice());
    }
}
