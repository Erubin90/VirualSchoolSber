package com.balda.gameClass;

import java.util.*;

public class Game {
    public static final int LENGTH_THE_SCREEN = 59;
    private String firstWord;
    private Set<Character> firstWordCharArray = new HashSet<>();
    private Set<String> setWords = new HashSet<>();
    private List<Player> playerList = new ArrayList<>();


    public Game() {

    }

    public String getFirstWord() {
        return firstWord;
    }

    public Set<Character> getFirstWordCharArray() {
        return firstWordCharArray;
    }

    public Player getPlayer(int numberPlayer) {
        return playerList.get(numberPlayer - 1);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public int getCountPlayer () {
        return playerList.size();
    }

    public List<Player> getWinnerPlayer () {
        var winnerPlayer = new ArrayList<Player>();
        winnerPlayer.add(playerList.get(0));
        for (Player player: playerList) {
            if (player != winnerPlayer.get(0) && player.getPoints() > 0){
                if (player.getPoints() > winnerPlayer.get(0).getPoints()) {
                    winnerPlayer.clear();
                    winnerPlayer.add(player);
                }
                else if (player.getPoints() == winnerPlayer.get(0).getPoints()) {
                    winnerPlayer.add(player);
                }
            }

        }
        return winnerPlayer;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
        this.setWords.add(firstWord);
        for (Character ch: firstWord.toCharArray()) {
            this.firstWordCharArray.add(ch);
        }
    }

    public boolean addWord(String word) {
        return setWords.add(word);
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }
}
