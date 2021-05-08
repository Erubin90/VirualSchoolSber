package com.balda;

import com.balda.gameClass.Game;
import com.balda.windows.EndWindows;
import com.balda.windows.PlayWindows;
import com.balda.windows.SettingWindows;
import com.balda.windows.StartWindows;

public class StartBalda {
    public static void main(String[] args) {
        var startWindows = new StartWindows();
        var settingWindows = new SettingWindows();
        var playWindows = new PlayWindows();
        var endWindows = new EndWindows();
        var game = new Game();

        boolean flagPlayGame = startWindows.mainMenu();
        while (flagPlayGame) {
            settingWindows.settingGame(game);
            if(!playWindows.playGame(game)){
                flagPlayGame = false;
            }
        }
        game.clear();
        endWindows.endGame();
    }
}
