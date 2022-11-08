package org.academiadecodigo.notorbios.pedrov.rockpapersacissors;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    /*
     * Icons
     * https://www.flaticon.com/free-icon/rock-paper-scissors_6727583
     * https://www.flaticon.com/free-icon/rock-paper-scissors_6650178
     * https://www.flaticon.com/free-icon/question_2476199
     * https://www.flaticon.com/free-icon/play_4208490
     * https://www.flaticon.com/free-icon/repeat_148752
     */

    private ImageButton btnPlay;
    private TextView txtP2Losses;
    private TextView txtP2Draws;
    private TextView txtP2Wins;
    private ImageButton btnP2Opt1;
    private ImageButton btnP2Opt2;
    private ImageButton btnP2Opt3;
    private TextView txtP2Result;
    private TextView txtP2;
    private View divider;
    private TextView txtP1;
    private TextView txtP1Result;
    private ImageButton btnP1Opt1;
    private ImageButton btnP1Opt2;
    private ImageButton btnP1Opt3;
    private TextView txtP1Wins;
    private TextView txtP1Draws;
    private TextView txtP1Losses;
    private ImageButton btnPlayAgain;

    private ImageButton p1Choise;
    private ImageButton p2Choise;

    private int[] results = new int[6];
    /*
        ? index results description ?
        0 - Player 2 Losses
        1 - Player 2 Draws
        2 - Player 2 Wins
        3 - Player 1 Wins
        4 - Player 1 Draws
        5 - Player 1 Losses
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVarsValues();

        // <Play Button>
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlay();
            }
        });
        // </Play Button>

        // <Buttons P1>
        btnP1Opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsP1(btnP1Opt1);
            }
        });

        btnP1Opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsP1(btnP1Opt2);
            }
        });

        btnP1Opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsP1(btnP1Opt3);
            }
        });
        // </Buttons P1>

        // <Buttons P2>
        btnP2Opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsP2(btnP2Opt1);
            }
        });

        btnP2Opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsP2(btnP2Opt2);
            }
        });

        btnP2Opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsP2(btnP2Opt3);
            }
        });
        // </Buttons P2>

        // <Play Again Button>
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPlayAgain();
            }
        });
        // </Play Again Button>
    }

    private void setVarsValues() {
        btnPlay = findViewById(R.id.btnPlay);
        txtP2Losses = findViewById(R.id.txtP2Losses);
        txtP2Draws = findViewById(R.id.txtP2Draws);
        txtP2Wins = findViewById(R.id.txtP2Wins);
        btnP2Opt1 = findViewById(R.id.btnP2Opt1);
        btnP2Opt2 = findViewById(R.id.btnP2Opt2);
        btnP2Opt3 = findViewById(R.id.btnP2Opt3);
        txtP2Result = findViewById(R.id.txtP2Result);
        txtP2 = findViewById(R.id.txtP2);
        divider = findViewById(R.id.divider);
        txtP1 = findViewById(R.id.txtP1);
        txtP1Result = findViewById(R.id.txtP1Result);
        btnP1Opt1 = findViewById(R.id.btnP1Opt1);
        btnP1Opt2 = findViewById(R.id.btnP1Opt2);
        btnP1Opt3 = findViewById(R.id.btnP1Opt3);
        txtP1Wins = findViewById(R.id.txtP1Wins);
        txtP1Draws = findViewById(R.id.txtP1Draws);
        txtP1Losses = findViewById(R.id.txtP1Losses);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);
    }

    private void buttonPlay() {
        btnPlay.setVisibility(View.INVISIBLE);

        randomChoisesButtons(true);
    }

    private void buttonsP1(ImageButton button) {
        if (button.getTag() != null) {
            btnP1Opt1.setClickable(false);
            btnP1Opt2.setClickable(false);
            btnP1Opt3.setClickable(false);

            p1Choise = button;

            randomChoisesButtons(false);
        }
    }

    private void buttonsP2(ImageButton button) {
        if (button.getTag() != null) {
            btnP2Opt1.setClickable(false);
            btnP2Opt2.setClickable(false);
            btnP2Opt3.setClickable(false);

            p2Choise = button;

            btnP2Opt1.setAlpha(0.5F);
            btnP2Opt1.setImageResource(R.drawable.wait_random);

            btnP2Opt2.setAlpha(0.5F);
            btnP2Opt2.setImageResource(R.drawable.wait_random);

            btnP2Opt3.setAlpha(0.5F);
            btnP2Opt3.setImageResource(R.drawable.wait_random);

            txtP2.setAlpha(0.25F);

            checkResult();
        }
    }

    private void buttonPlayAgain() {
        p2Choise.setAlpha(0.5F);
        p2Choise.setImageResource(R.drawable.wait_random);

        p1Choise.setAlpha(0.5F);
        p1Choise.setImageResource(R.drawable.wait_random);

        txtP2Result.clearAnimation();
        txtP1Result.clearAnimation();

        txtP2Result.setVisibility(View.INVISIBLE);
        txtP1Result.setVisibility(View.INVISIBLE);

        btnPlayAgain.setVisibility(View.INVISIBLE);

        randomChoisesButtons(true);
    }

    private void checkResult() {
        p2Choise.setImageResource(((Choices) p2Choise.getTag()).getSrc());
        p2Choise.setAlpha(1F);

        p1Choise.setImageResource(((Choices) p1Choise.getTag()).getSrc());
        p1Choise.setAlpha(1F);

        if ((Choices) p1Choise.getTag() == (Choices) p2Choise.getTag()) {
            results[1]++;
            results[4]++;

            txtP2Result.setTextColor(Color.parseColor("#1c3cdf"));
            txtP2Result.setText("DRAW");

            txtP1Result.setTextColor(Color.parseColor("#1c3cdf"));
            txtP1Result.setText("DRAW");

            txtP2Draws.setText("Draws: " + results[1]);
            txtP1Draws.setText("Draws: " + results[4]);
        } else if (((Choices) p1Choise.getTag()) == Choices.SACISSORS && ((Choices) p2Choise.getTag()) == Choices.PAPER) {
            player1Win();
        } else if (((Choices) p1Choise.getTag()) == Choices.ROCK && ((Choices) p2Choise.getTag()) == Choices.SACISSORS) {
            player1Win();
        } else if (((Choices) p1Choise.getTag()) == Choices.PAPER && ((Choices) p2Choise.getTag()) == Choices.ROCK) {
            player1Win();
        } else {
            results[2]++;
            results[5]++;

            txtP2Result.setTextColor(Color.parseColor("#2BB337"));
            txtP2Result.setText("WIN");

            txtP1Result.setTextColor(Color.parseColor("#FE0002"));
            txtP1Result.setText("LOSE");

            txtP2Wins.setText("Wins: " + results[2]);
            txtP1Losses.setText("Losses: " + results[5]);
        }

        txtP2Result.setPaintFlags(txtP2Result.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtP1Result.setPaintFlags(txtP1Result.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Animation animation = new AlphaAnimation(0F, 1F);
        animation.setDuration(100);
        animation.setStartOffset(20);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);

        txtP2Result.startAnimation(animation);
        txtP1Result.startAnimation(animation);

        txtP2Result.setVisibility(View.VISIBLE);
        txtP1Result.setVisibility(View.VISIBLE);

        divider.setVisibility(View.INVISIBLE);
        btnPlayAgain.setVisibility(View.VISIBLE);

        btnP1Opt1.setTag(null);
        btnP1Opt2.setTag(null);
        btnP1Opt3.setTag(null);

        btnP2Opt1.setTag(null);
        btnP2Opt2.setTag(null);
        btnP2Opt3.setTag(null);
    }

    private void player1Win() {
        results[0]++;
        results[3]++;

        txtP2Result.setTextColor(Color.parseColor("#FE0002"));
        txtP2Result.setText("LOSE");

        txtP1Result.setTextColor(Color.parseColor("#2BB337"));
        txtP1Result.setText("WIN");

        txtP2Losses.setText("Losses: " + results[0]);
        txtP1Wins.setText("Wins: " + results[3]);
    }

    private void randomChoisesButtons(boolean isP1) {
        // <Random Choises>
        Set<Choices> listRandomChoises = new LinkedHashSet<Choices>();

        while (listRandomChoises.size() < Choices.values().length) {
            listRandomChoises.add(Choices.values()[(new Random()).nextInt(Choices.values().length)]);
        }

        List<Choices> listChoises = new ArrayList<>(listRandomChoises);
        // </Random Choises>

        if (isP1) {
            btnP1Opt1.setTag(listChoises.get(0));
            btnP1Opt2.setTag(listChoises.get(1));
            btnP1Opt3.setTag(listChoises.get(2));

            txtP1.setAlpha(1F);

            divider.setVisibility(View.VISIBLE);

            btnP1Opt1.setImageResource(listChoises.get(0).getSrc());
            btnP1Opt2.setImageResource(listChoises.get(1).getSrc());
            btnP1Opt3.setImageResource(listChoises.get(2).getSrc());

            btnP1Opt1.setAlpha(1F);
            btnP1Opt1.setClickable(true);

            btnP1Opt2.setAlpha(1F);
            btnP1Opt2.setClickable(true);

            btnP1Opt3.setAlpha(1F);
            btnP1Opt3.setClickable(true);
        } else {
            btnP1Opt1.setAlpha(0.5F);
            btnP1Opt1.setImageResource(R.drawable.wait_random);

            btnP1Opt2.setAlpha(0.5F);
            btnP1Opt2.setImageResource(R.drawable.wait_random);

            btnP1Opt3.setAlpha(0.5F);
            btnP1Opt3.setImageResource(R.drawable.wait_random);

            txtP1.setAlpha(0.25F);

            btnP2Opt1.setTag(listChoises.get(0));
            btnP2Opt2.setTag(listChoises.get(1));
            btnP2Opt3.setTag(listChoises.get(2));

            txtP2.setAlpha(1F);

            btnP2Opt1.setImageResource(listChoises.get(0).getSrc());
            btnP2Opt2.setImageResource(listChoises.get(1).getSrc());
            btnP2Opt3.setImageResource(listChoises.get(2).getSrc());

            btnP2Opt1.setAlpha(1F);
            btnP2Opt1.setClickable(true);

            btnP2Opt2.setAlpha(1F);
            btnP2Opt2.setClickable(true);

            btnP2Opt3.setAlpha(1F);
            btnP2Opt3.setClickable(true);
        }
    }

}