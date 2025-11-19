package org.example.model;

public class Book implements Comparable<Book>{
    private int id;
    private static int index = 0;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String title;
    private double price;

    public static int generateId() {
        index++;
        return index;
    }

    public Book(String title, String author, double price) {
        this.id = generateId();
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
}
