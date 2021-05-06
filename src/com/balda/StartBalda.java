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

        boolean flagPlayGame = startWindows.mainMenu();
        while (flagPlayGame) {
            var game = new Game();
            settingWindows.settingGame(game);
            if(!playWindows.playGame(game)){
                flagPlayGame = false;
            }
        }
        endWindows.endGame();
    }
}
