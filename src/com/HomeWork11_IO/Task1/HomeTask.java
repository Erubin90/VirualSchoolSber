package com.HomeWork11_IO.Task1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HomeTask {
    public static void main(String[] args) {
        String path = "/src/com/HomeWork11_IO/Task1/file.txt";
        Scanner scanner = new Scanner(System.in);
        byte[] symbols = Stream.generate(scanner::nextLine)
                .limit(4)
                .collect(Collectors.joining())
                .getBytes();

        List<Byte> bytes = new ArrayList<>();
        for (byte b : symbols) {
            bytes.add(b);
        }

        try {
            OutputStream outFile = new FileOutputStream(path);
            for (Byte aByte : bytes) {
                outFile.write(aByte);
            }
            outFile.close();
            InputStream inFile = new FileInputStream(path);
            Stream.of(inFile).skip(2).forEach(System.out::println);
            inFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
