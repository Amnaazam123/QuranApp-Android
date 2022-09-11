package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ParaActivity extends AppCompatActivity {
    QDH store;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.para);
        store=new QDH();

        TextView nU=findViewById(R.id.paranameUU);
        Intent i =getIntent();
        String nameE=i.getStringExtra("nameE");
        String nameU=i.getStringExtra("nameU");
        int index = Integer.parseInt(i.getStringExtra("index"));
        int T_index = Integer.parseInt(i.getStringExtra("value"));

        DBhelper dbHelper  = new DBhelper(ParaActivity.this);



        ArrayList<tayah> list =dbHelper.getParah(index+1);

        recyclerView = findViewById(R.id.recyclerViewpara);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ParaActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new paraAdapter(getApplicationContext(),list,T_index) ;
        recyclerView.setAdapter(adapter);
        nU.setText(nameE);

    }
}