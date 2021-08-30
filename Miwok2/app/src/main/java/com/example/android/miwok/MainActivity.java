package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumbers(View view){
        Intent i = new Intent(this, Numbers.class);
        startActivity(i);
    }

    public void openFamilyMembers(View view){
        Intent i = new Intent(this, FamilyMembers.class);
        startActivity(i);
    }

    public void openColors(View view){
        Intent i = new Intent(this, Colours.class);
        startActivity(i);
    }

    public void openPhrases(View view){
        Intent i = new Intent(this, Phrases.class);
        startActivity(i);
    }
}