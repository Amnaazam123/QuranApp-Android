package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button surahIndex= findViewById(R.id.surahIndex);
        Button paraIndex=findViewById(R.id.paraIndex);


        Intent i=getIntent();
        int index = Integer.parseInt(i.getStringExtra("value"));

        surahIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surahIndex=new Intent(MainActivity.this,AllSurahNamesActivity.class);
                surahIndex.putExtra("value",String.valueOf( index));
                startActivity(surahIndex);
            }
        });

        paraIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surahIndex=new Intent(MainActivity.this,AllParaNamesActivity.class);
                surahIndex.putExtra("value",String.valueOf(index));
                startActivity(surahIndex);
            }
        });
    }
}