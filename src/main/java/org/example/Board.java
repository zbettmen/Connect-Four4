package org.example;

import java.util.ArrayList;

public class Board {
    public char[][]board;
    public ArrayList<Move> movesRecorded = new ArrayList<>();

    public Board() {
        board = new char[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void setBoard(char[][] newBoard) {
        board = newBoard;
    }

    public char[][] getBoard() {
        return board;
    }

    protected ArrayList<Move> getMovesRecorded() {
        return movesRecorded;
    }

    protected boolean boardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    protected void printBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print('|');
                System.out.print(board[i][j]);
            }
            System.out.print('|');
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    protected boolean[] throwDisc(Player p, int position) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][position] == ' ') {
                board[i][position] = p.getDiceValue();
                movesRecorded.add(new Move(p, new int[]{i, position}));
                boolean playerWon = new WinChecker().checkWin(getBoard(), position, i, p.getDiceValue());
                if (playerWon) {
                    return new boolean[]{true, true};
                }
                return new boolean[] {true, false};
            }
        }
        System.out.println("Disc has not been placed. All columns at this position has been filled!");
        return new boolean[] {false, false};
    }
}
