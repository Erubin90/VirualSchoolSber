package com.balda;

import java.util.*;

public class Balda {
    private String firstWord;
    private Set<Character> firstWordCharArray = new LinkedHashSet<>();
    private List<Player> playerList = new LinkedList<>();
    private Set<String> setWords = new HashSet<>();

    public Balda() {

    }

    public Balda(String firstWord) {
        this.firstWord = firstWord;
        for (Character ch: firstWord.toCharArray()) {
            this.firstWordCharArray.add(ch);
        }

    }

    public String getFirstWord() {
        return firstWord;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Set<Character> getFirstWordCharArray() {
        return firstWordCharArray;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
        this.setWords.add(firstWord);
        for (Character ch: firstWord.toCharArray()) {
            this.firstWordCharArray.add(ch);
        }
    }

    public int getCountPlayer () {
        return playerList.size();
    }

    public boolean addWord(String word) {
        return setWords.add(word);
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public Player getPlayer(int numberPlayer) {
        return playerList.get(numberPlayer - 1);
    }

    public List<Player> numWinnerPlayer () {
        List<Player> winnerPlayer = new LinkedList<>();
        winnerPlayer.add(playerList.get(0));
        for (Player player: playerList) {
            if (player.getPoints() > winnerPlayer.get(0).getPoints() && player.getPoints() > 0) {
                winnerPlayer.clear();
                winnerPlayer.add(player);
            }
            else if (player.getPoints() == winnerPlayer.get(0).getPoints() && player.getPoints() > 0) {
                winnerPlayer.add(player);
            }
        }
        if (winnerPlayer.size() == 1) {
            if (winnerPlayer.get(0).equals(playerList.get(0))) {
                winnerPlayer.remove(0);
                return winnerPlayer;
            }
            else {
                return winnerPlayer;
            }
        }
        return winnerPlayer;
    }
}
