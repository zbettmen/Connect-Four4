package org.example;


import java.util.Arrays;

public class Move {
    public Player player;
    public int[] coordinates;

    public Move(Player p, int[] c) {
        this.player = p;
        this.coordinates = c;
    }

    public Player getPlayer() {
        return player;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public String toString() {
        return getPlayer().getName() + ": " + Arrays.toString(getCoordinates());
    }
}