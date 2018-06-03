package com.example.dumnezeu.xsi0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //0 = yellow, 1 = red

    int activePlayer = 0;

    boolean gameIsActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winingPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


    //2 means unplayed

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        System.out.println(counter.getTag().toString());

        int tapppedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tapppedCounter] == 2 && gameIsActive) {
            gameState[tapppedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(200);
            for (int[] winingPositions : winingPositions) {
                if (gameState[winingPositions[0]] == gameState[winingPositions[1]] &&
                        gameState[winingPositions[1]] == gameState[winingPositions[2]] &&
                        gameState[winingPositions[0]] != 2) {

                    //cineva a castigat
                    gameIsActive = false;

                    String winner = "Rosu";
                    if (gameState[winingPositions[0]] == 0) {
                        winner = "Galben";
                    }

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " a castigat!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                } else {
                    boolean gameIsOver = true;
                    for (int counterSate : gameState) {
                        if (counterSate == 2) gameIsOver = false;
                    }
                    if (gameIsOver) {
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("Egalitate!");

                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);

                    }
                }
            }
        }
    }

    public void joacaDinNou(View view) {
        gameIsActive = true;
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);
        // GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}