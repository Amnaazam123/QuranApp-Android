package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button paraIndex;
    Button surahIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paraIndex = findViewById(R.id.paraIndex);
        surahIndex = findViewById(R.id.surahIndex);
        paraIndex.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ParaActivity.class);
                startActivity(i);
            }
        });

        surahIndex.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AllSurahNamesActivity.class);
                startActivity(i);
            }
        });


    }
}