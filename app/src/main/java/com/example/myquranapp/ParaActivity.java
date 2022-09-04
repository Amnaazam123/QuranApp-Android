package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ParaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para);

        ListView listView = findViewById(R.id.listView);
        ArrayList<String> paras = new ArrayList<>();
        paras.add("Para 1");
        paras.add("Para 2");
        paras.add("Para 3");
        paras.add("Para 4");
        paras.add("Para 5");
        paras.add("Para 6");
        paras.add("Para 7");
        paras.add("Para 8");
        paras.add("Para 9");
        paras.add("Para 10");
        paras.add("Para 11");
        paras.add("Para 12");
        paras.add("Para 13");
        paras.add("Para 14");
        paras.add("Para 15");
        paras.add("Para 16");
        paras.add("Para 17");
        paras.add("Para 18");
        paras.add("Para 19");
        paras.add("Para 20");
        paras.add("Para 21");
        paras.add("Para 22");
        paras.add("Para 23");
        paras.add("Para 24");
        paras.add("Para 25");
        paras.add("Para 26");
        paras.add("Para 27");
        paras.add("Para 28");
        paras.add("Para 29");
        paras.add("Para 30");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,paras);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ParaActivity.this,ParaText.class);
                DBhelper dbHelper  = new DBhelper(ParaActivity.this);
                ArrayList<tayah> list =dbHelper.Para(i+1);
                String para = new String();
                para="";
                for (int j = 0; j < list.size(); j++) {
                    tayah t=list.get(j);
                    para+= t.getArabicText().toString();
                }

                intent.putExtra("paraText",para);
                startActivity(intent);
            }
        });




    }
}