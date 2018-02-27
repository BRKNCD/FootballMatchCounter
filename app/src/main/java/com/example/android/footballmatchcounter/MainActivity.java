package com.example.android.footballmatchcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView team1Score;
    Button team1SubtractScore;
    Button team1AddScore;
    TextView team1YellowCards;
    TextView team1RedCards;
    TextView team1Offside;
    Button team1AddYellowCards;
    Button team1AddRedCards;
    TextView team1AddOffside;

    TextView team2Score;
    Button team2SubtractScore;
    Button team2AddScore;
    TextView team2YellowCards;
    TextView team2RedCards;
    TextView team2Offside;
    Button team2AddYellowCards;
    Button team2AddRedCards;
    TextView team2AddOffside;

    int team1Point;
    int team2Point;

    int team1YellowCardsN;
    int team2YellowCardsN;

    int team1RedCardsN;
    int team2RedCardsN;

    int team1OffsideN;
    int team2OffsideN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
    }

    public void initializeView() {
        team1Score = findViewById(R.id.team1_score);
        team1SubtractScore = findViewById(R.id.team1_subtract_goal);
        team1AddScore = findViewById(R.id.team1_add_goal);
        team1YellowCards = findViewById(R.id.team1_yellow_cards);
        team1RedCards = findViewById(R.id.team1_red_cards);
        team1Offside = findViewById(R.id.team1_offside);
        team1AddYellowCards = findViewById(R.id.team1_add_yellow_card);
        team1AddRedCards = findViewById(R.id.team1_add_red_card);
        team1AddOffside = findViewById(R.id.team1_add_offside);

        team2Score = findViewById(R.id.team2_score);
        team2SubtractScore = findViewById(R.id.team2_subtract_goal);
        team2AddScore = findViewById(R.id.team2_add_goal);
        team2YellowCards = findViewById(R.id.team2_yellow_cards);
        team2RedCards = findViewById(R.id.team2_red_cards);
        team2Offside = findViewById(R.id.team2_offside);
        team2AddYellowCards = findViewById(R.id.team2_add_yellow_card);
        team2AddRedCards = findViewById(R.id.team2_add_red_card);
        team2AddOffside = findViewById(R.id.team2_add_offside);
    }

    public void team1Goal(View view) {
        team1Point++;
        team1AddingViews(team1Score, team1Point);
    }

    public void team1GoalDenied(View view) {
        team1Point--;
        team1SubtractingViews(team1Score, team1Point);
    }

    public void team1YellowCard(View view) {
        team1YellowCardsN++;
        team1AddingViews(team1YellowCards, team1YellowCardsN);
    }

    public void team1RedCard(View view) {
        team1RedCardsN++;
        team1AddingViews(team1RedCards, team1RedCardsN);
    }

    public void team1Offside(View view) {
        team1OffsideN++;
        team1AddingViews(team1Offside, team1OffsideN);
    }

    public void team2Goal(View view) {
        team2Point++;
        team2AddingViews(team2Score, team2Point);
    }

    public void team2GoalDenied(View view) {
        team2Point--;
        team2SubtractingViews(team2Score, team2Point);
    }

    public void team2YellowCard(View view) {
        team2YellowCardsN++;
        team2AddingViews(team2YellowCards, team2YellowCardsN);
    }

    public void team2RedCard(View view) {
        team2RedCardsN++;
        team2AddingViews(team2RedCards, team2RedCardsN);
    }

    public void team2Offside(View view) {
        team2OffsideN++;
        team2AddingViews(team2Offside, team2OffsideN);
    }

    public void resetAll(View view) {

        if (Integer.parseInt(team1Score.getText().toString()) > Integer.parseInt(team2Score.getText().toString())) {

            Toast.makeText(this,
                    this.getResources().getString(R.string.team1_wins),
                    Toast.LENGTH_LONG).show();
        } else if (Integer.parseInt(team1Score.getText().toString()) < Integer.parseInt(team2Score.getText().toString())) {

            Toast.makeText(this,
                    this.getResources().getString(R.string.team2_wins),
                    Toast.LENGTH_LONG).show();
        } else if (Integer.parseInt(team1Score.getText().toString()) == Integer.parseInt(team2Score.getText().toString())) {
            Toast.makeText(this,
                    this.getResources().getString(R.string.draw),
                    Toast.LENGTH_LONG).show();
        }

        team1Point = 0;
        team2Point = 0;
        team1YellowCardsN = 0;
        team2YellowCardsN = 0;
        team1RedCardsN = 0;
        team2RedCardsN = 0;
        team1OffsideN = 0;
        team2OffsideN = 0;

        resetViews(team1Score, team1Point);
        resetViews(team1YellowCards, team1YellowCardsN);
        resetViews(team1RedCards, team1RedCardsN);
        resetViews(team1Offside, team1OffsideN);
        resetViews(team2Score, team2Point);
        resetViews(team2YellowCards, team2YellowCardsN);
        resetViews(team2RedCards, team2RedCardsN);
        resetViews(team2Offside, team2OffsideN);
    }

    public void team1AddingViews(TextView viewToAdd, int pointToAdd) {
        viewToAdd.setText("" + pointToAdd);
    }

    public void team1SubtractingViews(TextView viewToSubtract, int pointToSubtract) {
        if (Integer.parseInt(viewToSubtract.getText().toString()) > 0) {
            viewToSubtract.setText("" + pointToSubtract);
        }
    }

    public void team2AddingViews(TextView viewToAdd, int pointToAdd) {
        viewToAdd.setText("" + pointToAdd);
    }

    public void team2SubtractingViews(TextView viewToSubtract, int pointToSubtract) {
        if (Integer.parseInt(viewToSubtract.getText().toString()) > 0) {
            viewToSubtract.setText("" + pointToSubtract);
        }
    }

    public void resetViews(TextView viewToReset, int pointToReset) {
        viewToReset.setText("" + pointToReset);
    }
}
