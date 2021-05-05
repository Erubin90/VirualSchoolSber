package com.balda;

import java.util.*;

public class Windows extends Messages {

    public boolean mainMenu() {
        printMainMenu();
        return buttonYesNo();
    }

    public void settingGame(Balda balda) {
        printSettingGame();
        customization(balda);
    }

    public boolean playGame (Balda balda) {
        printStartGame(balda);
        int stopGame = 0;
        while (stopGame < balda.getCountPlayer()) {
            for (int i = 1; i <= balda.getCountPlayer(); i++) {
                printPlayersNickname(balda.getPlayer(i));
                if (!inputWord(balda, i)) {
                    stopGame++;
                }
            }
        }
        printSummaryTable(balda);
        return buttonYesNo();
    }

    private boolean buttonYesNo() {
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

    //settingGame(Balda balda)
    private void customization(Balda balda) {
        Scanner scan = new Scanner(System.in);
        printButtomSetting("Колличество игроков", "┤", "┘");
        int countPlayer = countPlayer();
        printButtomSetting("Изменим стандарные ники?", "1 - ДА | 2 - НЕТ" , "┐", "┘");
        if (buttonYesNo()) {
            for (int i = 0; i < countPlayer; i++) {
                String nickName;
                while (true) {
                    System.out.printf("│ Игрок%s -▶ ", (i + 1));
                    nickName = scan.nextLine();
                    if (nickName.length() <= 20 && nickName.length() > 0) {
                        break;
                    }
                    System.out.println("Такой ник " + nickName + " не подходит");
                }
                balda.addPlayer(new Player(nickName));
            }
        }
        else {
            for (int i = 0; i < countPlayer; i++) {
                balda.addPlayer(new Player("Игрок" + (i + 1)));
            }
        }
        printButtomSetting("Начальное слово", "┐", "┘");
        balda.setFirstWord(checkingWord());
    }

    private int countPlayer() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("│ ▶ ");
             int countPlayer = scan.nextInt();
            if (countPlayer > 1) {
                return countPlayer;
            }
        }
        catch (InputMismatchException ex) {

        }
        return countPlayer();
    }

    private String checkingWord() {
        Scanner scan = new Scanner(System.in);
            System.out.print("│ ▶ ");
            String word = scan.nextLine().toLowerCase();
            if (word.matches(".*\\d+.*")) {
                printInRightWord("Так не пойдет. Слово содердит число", " ");
                return checkingWord();
            }
            else if (word.matches(".*\\s+.*")) {
                printInRightWord("Так не пойдет. Слово содердит пробел", " ");
                return checkingWord();
            }
            else if (word.length() > 32) {
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

    //playGame (Balda balda)
    private boolean inputWord (Balda balda, int numPlayer) {
        String word = checkingWord();
        if (!word.isEmpty()) {
            ArrayList<Character> extraLetters = new ArrayList<>();
            Set<Character> firstWordsArrayCh = balda.getFirstWordCharArray();
            for (Character ch : word.toCharArray()) {
                if (firstWordsArrayCh.add(ch)) {
                    firstWordsArrayCh.remove(ch);
                    extraLetters.add(ch);
                }
            }
            if (extraLetters.isEmpty()) {
                if (balda.addWord(word)) {
                    balda.getPlayer(numPlayer).addWord(word);
                    System.out.println("│ Слово защитано. Переходим к следующему игроку");
                    return true;
                }
                else {
                    System.out.println("│ Такое слово уже есть. Придумай новое");
                    return inputWord(balda, numPlayer);
                }
            }
            else {
                System.out.print("│ В слове есть лишние буквы. A именно - ");
                for (Character ch : extraLetters) {
                    System.out.print(ch + " ");
                }
                System.out.println();
                return inputWord(balda, numPlayer);
            }

        }
        else {
            System.out.println("│ Пропуск хода");
            return false;
        }
    }
}
