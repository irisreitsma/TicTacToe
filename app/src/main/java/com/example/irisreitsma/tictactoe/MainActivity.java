package com.example.irisreitsma.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // lists for comparison
    int buttonID[] = {R.id.button11, R.id.button12, R.id.button13, R.id.button21, R.id.button22, R.id.button23, R.id.button31, R.id.button32, R.id.button33};
    int rows[]     = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    int columns[]  = {0, 1, 2, 0, 1, 2, 0, 1, 2};

    // properties of the class
    Game game;
    int row;
    int column;
    int length = buttonID.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reload same state
        if (savedInstanceState != null) {
            game = (Game) savedInstanceState.getSerializable("game");
            for (int i = 0; i < length; i++) {
                Tile tile = game.saveddraw(i/3, i%3);
                Button button = findViewById(buttonID[i]);
                switch (tile) {
                    case CROSS:
                        button.setText("X");
                        break;
                    case CIRCLE:
                        button.setText("O");
                        break;
                }
            }
        }
        else {
            game = new Game();
        }
    }

    // preserve state of game
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("game", game);
    }

    // methods of the class

    // puts a cross or circle on correct button
    public void tileClicked(View view) {
        Button button = (Button) view;
        int id = view.getId();

        for (int i = 0; i < length; i++) {
            if (id == buttonID[i]) {
                row = rows[i];
                column = columns[i];
            }
        }

        // updates button
        Tile tile = game.draw(row, column);
        switch (tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                Toast.makeText(MainActivity.this, "invalid move", Toast.LENGTH_SHORT).show();
                break;
        }

        // print state of game
        GameState state = game.state(row, column);
        switch (state) {
            case PLAYER_ONE:
                Toast.makeText(MainActivity.this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
                break;
            case PLAYER_TWO:
                Toast.makeText(MainActivity.this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
                break;
            case DRAW:
                Toast.makeText(MainActivity.this, "It's a draw!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // resets game
    public void resetClicked(View view) {
        for (int i : buttonID) {
            Button button = findViewById(i);
            button.setText("");
        }
        game = new Game();
    }
}
