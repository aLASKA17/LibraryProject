package org.example.sorted_book;

import org.example.model.Book;

import java.util.Comparator;

// Сортировка по названию
public class ComparatorByTitle implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return 0;
    }

    public int compareToByTitle(Book book1, Book book2){
        return CharSequence.compare(book1.getTitle(), book2.getTitle());
    }
}
