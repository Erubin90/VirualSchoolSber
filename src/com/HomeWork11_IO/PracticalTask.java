package com.HomeWork11_IO;

import java.io.File;
import java.util.Arrays;

public class PracticalTask {
    public static void main(String[] args) {
        File file = new File("/Users/ma/Desktop/C 42 min.rtf");
        String fileParentString = file.getAbsoluteFile().getParent();
        File[] files = new File(fileParentString).listFiles();
        if (files != null) {
            Arrays.stream(files)
                    .filter(f -> f.isFile() && f.getName().charAt(0) != '.')
                    .forEach(f -> System.out.print(f.getName() + ", "));
        }
    }
}
