package org.example;


public class Player {
    String name;
    char diceValue;
    int roundsWon = 0;

    protected Player(String name, char diceValue) {
        this.name = name;
        this.diceValue = diceValue;
    }

    protected int getRoundsWon() {
        return roundsWon;
    }

    protected char getDiceValue() {
        return diceValue;
    }

    protected String getName() {
        return name;
    }
}