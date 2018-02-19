package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class Quiz1 extends Activity implements View.OnClickListener {

    int points;
    String name;
    CheckBox checkBox;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    private ArrayList<CheckBox> mChecks;
    private ArrayList<CheckBox> mSelectedChecks;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);

        Intent nextScreen = getIntent();
        name = nextScreen.getStringExtra("name");

        mChecks = new ArrayList<>();
        mSelectedChecks = new ArrayList<>();

        checkBox = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);

        mChecks.add(checkBox);
        mChecks.add(checkBox2);
        mChecks.add(checkBox3);
        mChecks.add(checkBox4);

        for (CheckBox c : mChecks) {
            c.setOnClickListener(this);
        }
    }

    /**
     *  Only two checkboxes at the same time
     */

    @Override
    public void onClick(View view) {
        CheckBox c = (CheckBox) view;

        if (mSelectedChecks.contains(c)) {
            mSelectedChecks.remove(c);
        } else {
            if (mSelectedChecks.size() < 2) {
                mSelectedChecks.add(c);
            } else {
                mSelectedChecks.remove(0);
                mSelectedChecks.add(c);
            }
        }

        drawResults();
    }

    public void drawResults() {
        for (CheckBox c : mChecks) {
            c.setChecked(mSelectedChecks.contains(c));

        }

    }

    /**
     *  Handle the answer, check if it's correct add point and show Toast, move to next Activity
     */

    public void submitAnswer(View view) {

        boolean checked = checkBox.isChecked();
        boolean checked2 = checkBox2.isChecked();
        boolean checked3 = checkBox3.isChecked();
        boolean checked4 = checkBox4.isChecked();

        if (checked2 && checked4) {
            points += 1;
            Toast.makeText(getApplicationContext(), getString(R.string.correct), Toast.LENGTH_SHORT).show();
            nextPage(view);

        } else if (!checked && !checked2 && !checked3 && !checked4) {

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

        Intent nextScreen = new Intent(this, Quiz2.class);
        nextScreen.putExtra("points", points);
        nextScreen.putExtra("name", name);
        startActivity(nextScreen);
    }

}















