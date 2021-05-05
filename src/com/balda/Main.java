package com.balda;

public class Main {
    public static void main(String[] args) {
        Windows windows = new Windows();
        boolean playGame = windows.mainMenu();
        while (playGame) {
            Balda balda = new Balda();
            windows.settingGame(balda);
            if(!windows.playGame(balda)){
                playGame = false;
            }
        }
        windows.printLine("└", "─", "─");
    }
}
