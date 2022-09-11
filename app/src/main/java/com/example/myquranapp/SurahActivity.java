package com.example.myquranapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SurahActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah);

        TextView name=findViewById(R.id.surahName);
        ListView AllSurahList = findViewById(R.id.surahList);
        DBhelper dbHelper  = new DBhelper(SurahActivity.this);
        Intent i =getIntent();
        String nameE=i.getStringExtra("nameE");
        String nameU=i.getStringExtra("NameU");
        int index = Integer.parseInt(i.getStringExtra("index"));


        int t_index = Integer.parseInt(i.getStringExtra("value"));
        ArrayList<tayah> list =dbHelper.Surah(index+1);
        SurahAdapter sura=new SurahAdapter(this,list,t_index);



//        String namesurah = i.getStringExtra("surahName");
        AllSurahList.setAdapter(sura);
        name.setText(nameU);
//        DBhelper dbHelper  = new DBhelper(SurahActivity.this);
//        Intent i =getIntent();
//        int index = Integer.parseInt(i.getStringExtra("index"));
//
//
//        String namesurah = i.getStringExtra("surahName");
//        ArrayList<tayah> list =dbHelper.Surah(index+1);
//
//        String content = new String();
//        content="";
//        for (int j = 0; j < list.size(); j++) {
//            tayah t=list.get(j);
//            content+= t.getArabicText().toString();
//            // will print each index as it loops
//        }
//
//        fullsurah.setText(content);
//        name.setText(namesurah);


    }
}