package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        ArrayList<ArrayList> allMoves = new ArrayList<>();
        Random rand = new Random();
        System.out.println("Welcome to the Connect Four main.Game! How many rounds do you wanna play?");
        int rounds;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please select an odd number (eg. 3 or 5)");
            rounds = sc.nextInt();
        }while (rounds % 2 == 0);

        System.out.println("Write the name of player 1");
        String name1 = sc.next();

        System.out.println("Write the name of player 2");
        String name2 = sc.next();
        Player p1 = new Player(name1, 'X');
        Player p2 = new Player(name2, 'O');

        for (int i = 1; i <= rounds; i++) {

            int first = rand.nextInt(2)+1;
            Player currentPlayer;
            if (first == 1) {
                currentPlayer = p1;
            }else {
                currentPlayer = p2;
            }
            System.out.println(currentPlayer.getName() + " starts round " + i + " and is playing with " + currentPlayer.getDiceValue() + " dice!");

            Board b = new Board();
            do{
                b.printBoard();
                boolean[] discPlaced;
                do{
                    System.out.println(currentPlayer.getName() + ", choose a position at which to place the disc:");
                    discPlaced = b.throwDisc(currentPlayer, sc.nextInt());
                }while(Arrays.equals(discPlaced, new boolean[] {false, false}));

                if (Arrays.equals(discPlaced, new boolean[] {true, true})) {
                    currentPlayer.roundsWon++;
                    allMoves.add(b.getMovesRecorded());
                    System.out.println("Congratulations " + currentPlayer.getName() + "! You won round " + i + "! " +
                            "Currently you have " + currentPlayer.getRoundsWon() + " rounds won!\n");
                    b.printBoard();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (currentPlayer.getRoundsWon() > rounds/2) {
                        System.out.println(currentPlayer.getName() + " is the ultimate winner!!! main.Game Over!");
                        System.out.println("Here are all the moves in the game: ");
                        for (ArrayList match : allMoves) {
                            for (int k = 0; k < match.size(); k++) {
                                System.out.println(match.get(k).toString());
                            }
                            System.out.println("\n");
                        }
                        System.exit(0);
                    }
                    break;
                }
                if (currentPlayer.equals(p1)) {
                    currentPlayer = p2;
                }else {
                    currentPlayer = p1;
                }
            }while(!b.boardFull());
            if (b.boardFull()) {
                System.out.println("Round " + i + " was a tie! Restarting the round!");
                i--;
            }
        }
    }
}
