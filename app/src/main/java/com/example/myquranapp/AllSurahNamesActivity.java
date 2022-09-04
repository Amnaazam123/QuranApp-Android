package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AllSurahNamesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_for_main_activity);

        ListView AllSurahList = findViewById(R.id.AllSurahList);
        //recyclerView = findViewById(R.id.recycleView);

        DBhelper dbHelper  = new DBhelper(AllSurahNamesActivity.this);

        ArrayList<tsurah> list =dbHelper.getAllSurah();
        Log.d("nameOFSurah", String.valueOf(list.get(1)));

        SurahNameAdapter arrayAdapter = new SurahNameAdapter (this,list);
        /*recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(AllSurahNamesActivity.this,
                LinearLayoutManager.VERTICAL,
                true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(list) ;
        recyclerView.setAdapter(adapter);*/

        AllSurahList.setAdapter(arrayAdapter);

        AllSurahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DBhelper dbHelper = new DBhelper(AllSurahNamesActivity.this);
                tsurah s= (tsurah) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(AllSurahNamesActivity.this, SurahActivity.class);
                intent.putExtra("index", l + "");
                intent.putExtra("surahName", s.getSurahNameU());
                startActivity(intent);


            }
        });
    }
}