package com.balda.windows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckMethods implements Print {

     boolean buttonYesNo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("│ ▶ ");
        try {
            int num = scan.nextInt();
            if (num == 1) {
                return true;
            } else if (num == 2) {
                return false;
            }
        }
        catch (InputMismatchException ex) {
        }
        return buttonYesNo();
    }

    String checkingWord() {
        Scanner scan = new Scanner(System.in);
        System.out.print("│ ▶ ");
        String word = scan.nextLine().toLowerCase();
        if (word.matches(".*\\d+.*")) {
            printInRightWord("Слово не должно содержать число", " ");
            return checkingWord();
        }
        else if (word.matches(".*\\s+.*")) {
            printInRightWord("Слово не должно содержать пробел", " ");
            return checkingWord();
        }
        else if (word.length() >= 55) {
            printInRightWord("Таких длинных слов не существует", " ");
            return checkingWord();
        }
        else if (word.isEmpty()) {
            return word;
        }
        else {
            return word;
        }
    }
}
