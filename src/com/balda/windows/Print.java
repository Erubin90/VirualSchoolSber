package com.balda.windows;

import com.balda.gameClass.Game;
import com.balda.gameClass.Player;

import static com.balda.gameClass.Game.LENGTH_THE_SCREEN;


public interface Print {
    String[] balda = {
            "███████    ███     ███████       ███         ███  ",
            "██        ██ ██    ██   ██      ██ ██       ██ ██ ",
            "███████  ██   ██   ██   ██     ██   ██     ██   ██",
            "██   ██  ██▅▅▅██   ██   ██  █████████████  ██▅▅▅██",
            "██▅▅▅██  ██   ██  ▅██   ██  ██         ██  ██   ██"};
    String[] button = {
            "┌───┬─────────────────┐    ┌───┬─────────────────┐",
            "│ 1 │     Играть      │    │ 2 │  Выйти из игры  │",
            "└───┴─────────────────┘    └───┴─────────────────┘"};

    String[] buttonRemane = {
            "┌───┬─────────────────┐    ┌───┬─────────────────┐",
            "│ 1 │    Поменять     │    │ 2 │  Сгенерировать  │",
            "└───┴─────────────────┘    └───┴─────────────────┘"};

    String[] rulesGame = {
            "▶ Вводится изначально слово, а потом из букв",
            "  составляются слова",
            "▶ Повторятся слова не могут",
            "▶ Если слово составлено не из букв первого слова,",
            "  игрок будет оповещен об ошибке",
            "▶ Игра заканчивается в тот момент, когда все",
            "  игроки введут пустое слово \"\"",
            "▶ Количество игроков от 2",
            "▶ Ник игрока не должен быть длинее 20 символов",
            "▶ Размер начального слова ограничен 55 символомами",
            "▶ Правильность предложенных слов будут проверять",
            "  твои соперники"};

    default void printMainMenu() {

        printLine("┌", "─", "┐");
        printInMiddleWord("");
        printInMiddleWord(balda);
        printInMiddleWord("", "", "", "");
        printInMiddleWord(button);
        printInMiddleWord("", "");
        printLine("├", "─", "┘");
        System.out.println("│ Введите соответвствующее число");
    }

    default void printSettingGame() {
        printLine("├", "─", "┐");
        printInMiddleWord("Правила игры");
        printLine("├", "─", "┤");
        for (String str : rulesGame) {
            if (str.length() <= LENGTH_THE_SCREEN - 3) {
                printInRightWord(str, " ");
            }
        }
        printLine("├", "─", "┤");
        printInMiddleWord("Настройка игры");
    }

    default void printLinesInFrame(String... ch) {
        printLine("├", "─", ch[ch.length - 2]);
        for (int i = 0; i < ch.length - 2; i++) {
            printInMiddleWord(ch[i]);
        }
        printLine("├", "─", ch[ch.length - 1]);
    }

    default void printButtonRename(String str, String ch1, String ch2) {
        if (str.isEmpty()) {
            printLine("├", "─", ch1);
            printInMiddleWord(buttonRemane);
            printLine("├", "─", ch2);
        }
        else {
            printLine("├", "─", ch1);
            printInMiddleWord(str);
            printInMiddleWord(buttonRemane);
            printLine("├", "─", ch2);
        }
    }

    default void printStartGame(Game game){
        printLinesInFrame("БАЛДА", "Начальное слово", game.getFirstWord(), "┐", "┘");
    }

    default void printSummaryTable(Game game) {
        printLinesInFrame("Начальное слово", game.getFirstWord(), "┐",  "┤");
        for (Player player: game.getPlayerList()) {
            printInMiddleWord(player.getName() + " -▶ " + player.getPoints());
            for (String str : player.getWords()) {
                printInMiddleWord(str);
            }
            printLine("├", "─", "┤");
        }
        if (game.getWinnerPlayer().size() > 1) {
            printInMiddleWord("Победители");
            printInMiddleWord("");
            for (Player player : game.getWinnerPlayer()) {
                printInMiddleWord(player.getName());
            }
            printLine("├", "─", "┤");
        }
        else if (game.getWinnerPlayer().size() == 1) {
            printInMiddleWord("Победитель");
            printInMiddleWord("");
            printInMiddleWord(game.getWinnerPlayer().get(0).getName());
            printLine("├", "─", "┤");
        }
        printInMiddleWord("Ссырграем снова?");
        for (String str : button) {
            printInMiddleWord(str);
        }
        printLine("├", "─", "┘");
    }

    default void printLine(String ... detail) {
        System.out.print(detail[0]);
        printStringOfChar(LENGTH_THE_SCREEN, detail[1]);
        System.out.println(detail[2]);
    }

    default void printPlayersNickname(Player player) {
        System.out.println("│ " + player.getName());
    }

    default void printInMiddleWord(String... str) {
        for (String s : str) {
            int countSpaces = LENGTH_THE_SCREEN - s.length();
            System.out.print("│");
            printStringOfChar(countSpaces / 2, " ");
            System.out.print(s);
            if (countSpaces % 2 == 0) {
                printStringOfChar(countSpaces / 2, " ");
            } else {
                printStringOfChar(countSpaces / 2 + 1, " ");
            }
            System.out.println("│");
        }
    }

    default void printInRightWord(String str, String retreat) {
        System.out.print("│");
        System.out.print(retreat + str);
        int countCh = LENGTH_THE_SCREEN - str.length() - retreat.length();
        printTheEndLine(countCh, " ");
    }

    default void printTheEndLine(int countCh, String ch) {
        printStringOfChar(countCh, ch);
        System.out.println("│");
    }

    default void printStringOfChar(int countCh, String ch) {
        for (int w = 0; w < countCh / 2; w++) {
            System.out.print(ch + ch);
        }
        if (countCh % 2 == 1) {
            System.out.print(ch);
        }
    }
}
