package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText inputName;
    String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnNextScreen = findViewById(R.id.proceed);
            btnNextScreen.setOnClickListener(new View.OnClickListener() {


                public void onClick(View arg0) {

                    inputName = findViewById(R.id.name);
                    name = inputName.getText().toString();

                    if (!name.isEmpty()) {

                        Intent nextScreen = new Intent(getApplicationContext(), quiz1.class);
                        nextScreen.putExtra("name", name);
                        startActivity(nextScreen);

                    } else {

                        Toast.makeText(getApplicationContext(), getString(R.string.no_name), Toast.LENGTH_SHORT).show();

                    }
                }

            });
        }




    }








