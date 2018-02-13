package com.example.irisreitsma.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.irisreitsma.tictactoe.Tile.CROSS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // lists for comparison
    int buttonID[] = {R.id.button11, R.id.button12, R.id.button13, R.id.button21, R.id.button22, R.id.button23, R.id.button31, R.id.button32, R.id.button33};
    int rows[]     = {1, 1, 1, 2, 2, 2, 3, 3, 3};
    int columns[]  = {1, 2, 3, 1, 2, 3, 1, 2, 3};

    // properties of the class
    Game game;
    int row;
    int column;

    // methods of the class
    public void onCreate() {
        game = new Game();
    }

    // puts a cross or circle on correct button
    public void tileClicked(View view) {
        Button button = (Button) view;
        int id = view.getId();
        int length = buttonID.length;

        for (int i : buttonID) {
            if (id == buttonID[i]) {
                int row = rows[i];
                int column = columns[i];
            }
        }

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
    }

    // resets game
    public void resetClicked() {
        for (int i : buttonID) {
            Button button = findViewById(i);
            button.setText("");
        }

        game = new Game();
    }
}
