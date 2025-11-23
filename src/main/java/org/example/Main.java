package org.example;


import org.example.exception.NotMenuPointException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, NotMenuPointException {

        App app = new App();
        app.run();
    }
}