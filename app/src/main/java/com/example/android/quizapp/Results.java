package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends Activity {

    int points;
    String name;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Intent nextScreen = getIntent();
        points = nextScreen.getIntExtra("points", 0);
        name = nextScreen.getStringExtra("name");

        Resources res = getResources();
        String text = res.getString(R.string.result, name, points);

        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText(text);

        Toast.makeText(getApplicationContext(), getString(R.string.result, name, points), Toast.LENGTH_LONG).show();

    }

    public void submitAnswer(View view) {
       nextPage(view);
    }

    /**
     *  Intent for next Activity
     */

    public void nextPage(View view) {

        //Starting a new Intent
        Intent nextScreen = new Intent(this, MainActivity.class);
        startActivity(nextScreen);
    }
}


