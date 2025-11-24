package org.example.file;

import org.example.controller.LibraryUser;
import org.example.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {


    public String init() throws FileNotFoundException {
        String currentDirectory = System.getProperty("user.dir");
        return currentDirectory + "\\src\\main\\java\\org\\example\\file\\save.ser";
    }


    public void saveBooks(List<Book> books){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(init()))){
            oos.writeObject(books);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importBooks(List<Book> books){
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(init()))){
           books = (List<Book>) ois.readObject();
           System.out.println(books.toString());
       } catch (IOException | ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
    }
}
