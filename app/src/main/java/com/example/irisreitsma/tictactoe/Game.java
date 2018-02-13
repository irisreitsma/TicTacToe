package com.example.irisreitsma.tictactoe;

/**
 * Created by Iris Reitsma on 13-2-2018.
 */

public class Game {

    // properties of the class
    final private int BOARD_SIZE = 3;
    private Tile[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    // constructor of the class
    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    // methods of the class
    public Tile draw(int row, int column) {
        if (board[row][column] == Tile.BLANK) {
            if (playerOneTurn){
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                return Tile.CROSS;
            }
            else {
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                return Tile.CIRCLE;
            }
        }
        else {
            return Tile.INVALID;
        }
    }
}
