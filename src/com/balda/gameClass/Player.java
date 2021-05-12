package com.balda.gameClass;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> words = new ArrayList<>();
    private int points = 0;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        points += word.length();
        words.add(word);
    }

    public int getPoints() {
        return points;
    }
}
