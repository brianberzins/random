package org.murasaki;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Walker {
    Random random;
    int iteration;
    int value;
    FileOutputStream fileOutputStream;

    public Walker(int value) throws FileNotFoundException {
        this.random = new Random();
        this.iteration = 0;
        this.value = value;
        this.fileOutputStream = new FileOutputStream("out.csv");
    }

    void print() throws IOException {
        fileOutputStream.write(String.format("%d,%d%n", iteration, value).getBytes(StandardCharsets.UTF_8));
        System.out.printf("%d,%d%n", iteration, value);
    }

    void walk() throws IOException {
        print();
        while (value != 1) {
            int next = random.nextInt(value) + 1;
            if (next == 1) {
                print();
                value--;
            } else if (next == value) {
                print();
                value++;
            }
            iteration++;
        }
        print();
    }

    public static void main(String[] args) throws IOException {
        new Walker(100).walk();
    }
}
