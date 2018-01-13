package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class quiz3 extends Activity {


    int points;
    String name;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3);

        Intent nextScreen = getIntent();
        points = nextScreen.getIntExtra("points", 0);
        name = nextScreen.getStringExtra("name");

    }

    /**
     *  Handle the answer, check if it's correct add point and show Toast, move to next Activity
     */

    public void submitAnswer(View view) {
        EditText inputAnswer = findViewById(R.id.edit_text);
        String name = inputAnswer.getText().toString();

        if (name.equals("112")) {
            points += 1;
            Toast.makeText(getApplicationContext(), getString(R.string.correct), Toast.LENGTH_SHORT).show();
            nextPage(view);

        } else if (name.isEmpty()) {
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
        Intent nextScreen = new Intent(this, quiz4.class);
        nextScreen.putExtra("points", points);
        nextScreen.putExtra("name", name);
        startActivity(nextScreen);
    }

}




