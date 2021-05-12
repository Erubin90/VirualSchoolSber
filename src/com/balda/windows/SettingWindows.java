package com.balda.windows;

import com.balda.gameClass.Player;
import com.balda.gameClass.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SettingWindows extends CheckMethods implements Print{
    public void settingGame(Game game) {
        printSetting();
        customization(game);
    }

    private void customization(Game game) {
        Scanner scan = new Scanner(System.in);
        printLinesInFrame("Колличество игроков", "┤", "┘");
        int countPlayer = countPlayer();
        printButtonRename("Изменим стандарные ники?", "┐", "┘");
        if (buttonYesNo()) {
            for (int i = 0; i < countPlayer; i++) {
                String nickName;
                while (true) {
                    System.out.printf("│ Игрок%s -▶ ", (i + 1));
                    nickName = scan.nextLine();
                    if (nickName.length() <= 20 && nickName.length() > 0) {
                        break;
                    }
                    printInMiddleWord("Такой ник " + nickName + " не подходит");
                }
                game.addPlayer(new Player(nickName));
            }
        }
        else {
            for (int i = 0; i < countPlayer; i++) {
                game.addPlayer(new Player("Игрок" + (i + 1)));
            }
        }
        printLinesInFrame("Начальное слово", "┐", "┘");
        game.setFirstWord(checkingWord());
    }

    private int countPlayer() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("│ ▶ ");
            int countPlayer = scan.nextInt();
            if (countPlayer > 1 && countPlayer <= 10) {
                return countPlayer;
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("│  На ввод принимается только число от 2 до 10");
        }
        return countPlayer();
    }
}
