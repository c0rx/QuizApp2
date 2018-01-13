package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


public class quiz4 extends Activity {

    int points;
    String name;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz4);

        Intent nextScreen = getIntent();
        points = nextScreen.getIntExtra("points", 0);
        name = nextScreen.getStringExtra("name");

    }

    /**
     *  Handle the answer, check if it's correct add point and show Toast, move to next Activity
     */

    public void submitAnswer(View view) {

        RadioButton radio1 = findViewById(R.id.radio1);
        boolean checked1 = radio1.isChecked();
        RadioButton radio2 = findViewById(R.id.radio2);
        boolean checked2 = radio2.isChecked();
        RadioButton radio3 = findViewById(R.id.radio3);
        boolean checked3 = radio3.isChecked();
        RadioButton radio4 = findViewById(R.id.radio4);
        boolean checked4 = radio4.isChecked();

        if (checked2) {
            points += 1;
            Toast.makeText(getApplicationContext(), getString(R.string.correct), Toast.LENGTH_SHORT).show();
            nextPage(view);

        } else if (!checked1 && !checked2 && !checked3 && !checked4) {

            Toast.makeText(getApplicationContext(), getString(R.string.no_answer), Toast.LENGTH_SHORT).show();

        } else

        {
            Toast.makeText(getApplicationContext(), getString(R.string.wrong), Toast.LENGTH_SHORT).show();
            nextPage(view);
        }
    }

    /**
     *  Intent for next Activity, pass there points and name
     */

    public void nextPage(View view) {

        //Starting a new Intent
        Intent nextScreen = new Intent(this, quiz5.class);
        nextScreen.putExtra("points", points);
        nextScreen.putExtra("name", name);
        startActivity(nextScreen);
    }

}
