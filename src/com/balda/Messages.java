package com.balda;

public class Messages {
    protected final int LENGTH_THE_SCREEN = 59;
    String[] balda = {
            "*******    ***     *******       ***        ***  ",
            "**        ** **    **   **      ** **      ** ** ",
            "*******  **   **   **   **     **   **    **   **",
            "**   **  *******   **   **  ************  *******",
            "*******  **   **  ***   **  **        **  **   **"};
    String[] button = {
            "┌───┬─────────────────┐    ┌───┬─────────────────┐",
            "│ 1 │     Играть      │    │ 2 │  Выйти из игры  │",
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

    protected void printMainMenu() {

        printLine("┌", "─", "┐");
        printInMiddleWord("");
        for (String str : balda) {
            printInMiddleWord(str);
        }
        printInMiddleWord(4,"");
        for (String str : button) {
            printInMiddleWord(str);
        }
        printInMiddleWord(2,"");
        printLine("├", "─", "┘");
        System.out.println("│ Введите соответвствующее число");
    }

    protected void printSettingGame() {
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

    protected void printButtomSetting (String... ch) {
        printLine("├", "─", ch[ch.length - 2]);
        for (int i = 0; i < ch.length - 2; i++) {
            printInMiddleWord(ch[i]);
        }
        printLine("├", "─", ch[ch.length - 1]);
    }

    protected void printStartGame (Balda balda){
        printButtomSetting("БАЛДА", "Начальное слово", balda.getFirstWord(), "┐", "┘");
    }

    protected void printSummaryTable(Balda balda) {
        printButtomSetting("Начальное слово", balda.getFirstWord(), "┐",  "┤");
        for (Player player: balda.getPlayerList()) {
            printInMiddleWord(player.getName() + " -▶ " + player.getPoints());
            for (String str : player.getWords()) {
                printInMiddleWord(str);
            }
            printLine("├", "─", "┤");
        }
        if (balda.numWinnerPlayer().size() > 1) {
            printInMiddleWord("Победители");
            printInMiddleWord("");
            for (Player player : balda.numWinnerPlayer()) {
                printInMiddleWord(player.getName());
            }
            printLine("├", "─", "┤");
        }
        else if (balda.numWinnerPlayer().size() == 1) {
            printInMiddleWord("Победитель");
            printInMiddleWord("");
            printInMiddleWord(balda.numWinnerPlayer().get(0).getName());
            printLine("├", "─", "┤");
        }
        printInMiddleWord("Ссырграем снова?");
        for (String str : button) {
            printInMiddleWord(str);
        }
        printLine("├", "─", "┤");
    }

    protected void printLine( String ... detail) {
        System.out.print(detail[0]);
        printStringOfChar(LENGTH_THE_SCREEN, detail[1]);
        System.out.println(detail[2]);
    }

    protected void printPlayersNickname(Player player) {
        System.out.println("│ " + player.getName());
    }

    //добавить ошибку длинной строки
    protected void printInMiddleWord(String str) {
        int countSpaces = LENGTH_THE_SCREEN - str.length();
        System.out.print("│");
        printStringOfChar(countSpaces / 2, " ");
        System.out.print(str);
        if (countSpaces % 2 == 0) {
            printStringOfChar(countSpaces / 2, " ");
        }
        else {
            printStringOfChar(countSpaces / 2 + 1, " ");
        }
        System.out.println("│");
    }

    protected void printInMiddleWord(int count, String str) {
        int countSpaces = LENGTH_THE_SCREEN - str.length();
        for (int i = 0; i < count; i++) {
            System.out.print("│");
            printStringOfChar(countSpaces / 2, " ");
            System.out.print(str);
            if (countSpaces % 2 == 0) {
                printStringOfChar(countSpaces / 2, " ");
            } else {
                printStringOfChar(countSpaces / 2 + 1, " ");
            }
            System.out.println("│");
        }
    }

    protected void printInRightWord(String str, String retreat) {
        System.out.print("│");
        System.out.print(retreat + str);
        int countCh = LENGTH_THE_SCREEN - str.length() - retreat.length();
        printTheEndLine(countCh, " ");
    }

    protected void printTheEndLine (int countCh, String ch) {
        printStringOfChar(countCh, " ");
        System.out.println("│");
    }

    protected void printStringOfChar(int countCh, String ch) {
        for (int w = 0; w < countCh / 2; w++) {
            System.out.print(ch + ch);
        }
        if (countCh % 2 == 1) {
            System.out.print(ch);
        }
    }

}
