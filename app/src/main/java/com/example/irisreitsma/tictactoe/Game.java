package com.example.irisreitsma.tictactoe;

import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by Iris Reitsma on 13-2-2018.
 */

public class Game implements Serializable {

    // properties of the class
    final private int BOARD_SIZE = 3;
    private Tile[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private boolean gameOver;

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

    // draw board
    public Tile draw(int row, int column) {
        if (board[row][column] == Tile.BLANK && !gameOver) {
            if (playerOneTurn) {
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                movesPlayed++;
                return Tile.CROSS;
            } else {
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                movesPlayed++;
                return Tile.CIRCLE;
            }
        } else {
            return Tile.INVALID;
        }
    }
    // draw saved board
    public Tile saveddraw(int row, int column) {
        if (board[row][column] == Tile.CROSS) {
            return Tile.CROSS;
        } if (board[row][column] == Tile.CIRCLE) {
            return Tile.CIRCLE;
        } else {
            return Tile.BLANK;
        }
    }

    // check state of game
    public GameState state(int row, int column) {
        // check for win
        for (int i=0; i<BOARD_SIZE; i++) {
            // check rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == Tile.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                } if (board[i][0] == Tile.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            }
            // check columns
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                if (board[0][i] == Tile.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                } if (board[0][i] == Tile.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            }
        }
        // check diagonals
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            if (board[0][0] == Tile.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            } if (board[0][0] == Tile.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            if (board[0][2] == Tile.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            } if (board[0][2] == Tile.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        }

        // check for draw
        if (movesPlayed == 9) {
            gameOver = true;
            return GameState.DRAW;
        }

        // game is in progress
        else {
            return GameState.IN_PROGRESS;
        }
    }
}
