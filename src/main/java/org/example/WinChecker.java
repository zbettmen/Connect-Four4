package org.example;

public class WinChecker {

    public boolean checkWin(char[][] board, int colomnPos, int rowPos, char discValue) {
        return (checkVerticalWin(board, colomnPos, rowPos, discValue) || checkHorizontalWin(board, colomnPos, rowPos, discValue) || checkDiagonalWin(board, colomnPos, rowPos, discValue));
    }

    public boolean checkHorizontalWin(char[][] board, int colomnPos, int rowPos, char discValue) {
        boolean nextLeftIsYours = true;
        int i = colomnPos;
        int count = 1;
        do{
            if (i > 0 && board[rowPos][i-1] == discValue) {
                count++;
                i = i - 1;
            }else {
                nextLeftIsYours = false;
            }
        } while (nextLeftIsYours);
        boolean nextRightIsYours = true;
        i = colomnPos;
        do{
            if (i < 6 && board[rowPos][i+1] == discValue) {
                count++;
                i = i + 1;
            }else {
                nextRightIsYours = false;
            }
        } while (nextRightIsYours);

        return count >=4;
    }

    public boolean checkVerticalWin(char[][] board, int colomnPos, int rowPos, char discValue) {
        boolean nextDownIsYours = true;
        int i = rowPos;
        int count = 1;
        do{
            if (i < 5 && board[i+1][colomnPos] == discValue) {
                count++;
                i = i + 1;
            }else {
                nextDownIsYours = false;
            }
        } while (nextDownIsYours);

        return count >=4;
    }

    public boolean checkDiagonalWin(char[][] board, int colomnPos, int rowPos, char discValue) {
        boolean nextRightUpIsYours = true;
        int r = rowPos;
        int c = colomnPos;
        int count = 1;
        do{
            if (r > 0 && c < 6 && board[r-1][c+1] == discValue) {
                count++;
                r = r - 1;
                c = c + 1;
            }else {
                nextRightUpIsYours = false;
            }
        }while(nextRightUpIsYours);

        boolean nextLeftDownIsYours = true;
        r = rowPos;
        c = colomnPos;
        do{
            if (r < 5 && c > 0 && board[r+1][c-1] == discValue) {
                count++;
                r = r + 1;
                c = c - 1;
            }else {
                nextLeftDownIsYours = false;
            }
        }while(nextLeftDownIsYours);

        if (count >= 4) {
            return true;
        }else {
            boolean nextLeftUpIsYours = true;
            r = rowPos;
            c = colomnPos;
            count = 1;
            do{
                if (r > 0 && c > 0 && board[r-1][c-1] == discValue) {
                    count++;
                    r = r - 1;
                    c = c - 1;
                }else {
                    nextLeftUpIsYours = false;
                }
            }while(nextLeftUpIsYours);

            boolean nextRightDownIsYours = true;
            r = rowPos;
            c = colomnPos;
            do{
                if (r < 5 && c < 6 && board[r+1][c+1] == discValue) {
                    count++;
                    r = r + 1;
                    c = c + 1;
                }else {
                    nextRightDownIsYours = false;
                }
            }while(nextRightDownIsYours);

            return count >= 4;
        }
    }
}