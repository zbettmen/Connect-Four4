package org.example;

public class GameTest {
    private WinChecker winChecker;
    private Board board;


    @BeforeEach
    void setUp() throws Exception {
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