package com.HomeWork11_IO.Task1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HomeTask2 {
    public static void main(String[] args) {
        File loveJavaFile = new File("/Users/ma/IdeaProjects/VirualSchoolSber/src/com/HomeWork11_IO/Task1/loveJava.txt");
        String str = "Люблю Java!";
        try {
            if (loveJavaFile.createNewFile()) {
                OutputStream outFile = new BufferedOutputStream(new FileOutputStream(loveJavaFile.getAbsoluteFile()));
                outFile.write(str.getBytes(StandardCharsets.UTF_16));
                outFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
