package com.balda.windows;

import com.balda.gameClass.*;

public class StartWindows extends CheckMethods implements Print {
    public boolean mainMenu() {
        printMainMenu();
        return buttonYesNo();
    }
}
