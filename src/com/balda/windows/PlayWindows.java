package com.balda.windows;

import com.balda.gameClass.Game;

import java.util.ArrayList;
import java.util.Set;

public class PlayWindows extends CheckMethods implements Print {
    public boolean playGame (Game game) {
        printStartGame(game);
        int stopGame = 0;
        while (stopGame < game.getCountPlayer()) {
            stopGame = 0;
            for (int i = 1; i <= game.getCountPlayer(); i++) {
                printPlayersNickname(game.getPlayer(i));
                if (!inputWord(game, i)) {
                    stopGame++;
                }
            }
        }
        printSummaryTable(game);
        return buttonYesNo();
    }

    private boolean inputWord (Game game, int numPlayer) {
        String word = checkingWord();
        if (!word.isEmpty()) {
            ArrayList<Character> extraLetters = new ArrayList<>();
            Set<Character> firstWordsArrayCh = game.getFirstWordCharArray();
            for (Character ch : word.toCharArray()) {
                if (firstWordsArrayCh.add(ch)) {
                    firstWordsArrayCh.remove(ch);
                    extraLetters.add(ch);
                }
            }
            if (extraLetters.isEmpty()) {
                if (game.addWord(word)) {
                    game.getPlayer(numPlayer).addWord(word);
                    System.out.println("│ Слово защитано");
                    return true;
                }
                else {
                    System.out.println("│ Такое слово уже предлогалось");
                    return inputWord(game, numPlayer);
                }
            }
            else {
                System.out.print("│ В слове есть лишние буквы. A именно - ");
                for (Character ch : extraLetters) {
                    System.out.print(ch + " ");
                }
                System.out.println();
                return inputWord(game, numPlayer);
            }

        }
        else {
            System.out.println("│ Пропуск хода");
            return false;
        }
    }
}
