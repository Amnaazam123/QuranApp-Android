package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ParaText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_text);

        TextView fullPara=findViewById(R.id.para);
        Intent i =getIntent();
        String paraText = i.getStringExtra("paraText");
        fullPara.setText(paraText);


    }
}