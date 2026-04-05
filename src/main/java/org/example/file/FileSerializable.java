package org.example.file;

import org.example.model.Book;

import java.io.*;
import java.util.List;

public class FileSerializable {

    // Инициализация файла
    public String init() throws FileNotFoundException {
        String currentDirectory = System.getProperty("user.dir");
        return currentDirectory + "\\src\\main\\java\\org\\example\\file\\save.ser";
    }

    // Сохранения книг в файле с помощью сериализации
    public void saveBooks(List<Book> books){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(init()))){
            oos.writeObject(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Импорт файл в список книг с помощью десериализации
    public List<Book> importBooks(){
        List<Book> books;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(init()))){
            books = (List<Book>) ois.readObject();
           System.out.println(books.toString());
       } catch (IOException | ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return books;
    }
}
