package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private WinChecker winChecker;
    private Board board;


    @BeforeEach
    void setUp() {
        winChecker = new WinChecker();
        board = new Board();
    }

    @Test
    void testCheckVerticalWinTrue() {
        char[][] newArr= {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
    };
        board.setBoard(newArr);
        Assertions.assertTrue(winChecker.checkVerticalWin(board.getBoard(), 0, 2, 'X'));
    }

    @Test
    void testCheckVerticalWinFalse() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertFalse(winChecker.checkVerticalWin(board.getBoard(), 0, 2, 'X'));
    }

    @Test
    void testCheckHorizontalWinTrue() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', 'O', 'X', 'X', 'X', 'X', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertTrue(winChecker.checkHorizontalWin(board.getBoard(), 5, 5, 'X'));
    }

    @Test
    void testCheckHorizontalWinFalse() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', 'O', 'X', 'X', ' ', ' ', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertFalse(winChecker.checkVerticalWin(board.getBoard(), 4, 5, 'X'));
    }

    @Test
    void testCheckDiagonalWinTrue() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', 'O', 'X', ' ', ' '},
                {' ', ' ', 'O', 'O', 'X', ' ', ' '},
                {'X', 'O', 'X', 'X', 'X', ' ', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertTrue(winChecker.checkDiagonalWin(board.getBoard(), 4, 2, 'O'));
    }

    @Test
    void testCheckDiagonalWinFalse() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', 'X', 'X', ' ', ' '},
                {' ', ' ', 'O', 'O', 'X', ' ', ' '},
                {'X', 'O', 'X', 'X', 'X', ' ', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertFalse(winChecker.checkDiagonalWin(board.getBoard(), 4, 2, 'O'));
    }

    @Test
    void testWinTrue() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', 'X', ' ', 'O', ' ', ' '},
                {' ', 'O', 'O', 'X', 'X', ' ', ' '},
                {' ', 'O', 'O', 'O', 'X', ' ', ' '},
                {'X', 'O', 'X', 'X', 'X', ' ', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertTrue(winChecker.checkWin(board.getBoard(), 1, 1, 'X'));
    }

    @Test
    void testWinFalse() {
        char[][] newArr= {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'O', ' ', ' ', 'O', ' ', ' '},
                {' ', 'X', 'O', 'O', 'X', ' ', ' '},
                {' ', 'X', 'O', 'O', 'O', ' ', ' '},
                {'X', 'O', 'X', 'X', 'X', ' ', ' '},
        };
        board.setBoard(newArr);
        Assertions.assertFalse(winChecker.checkWin(board.getBoard(), 0, 5, 'X'));
    }
}
