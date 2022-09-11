package com.example.myquranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Locale;

public class AllSurahNamesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    All_Surah_nameAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<tsurah> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_main);
        Intent i = getIntent();
        int T_index = Integer.parseInt(i.getStringExtra("value"));

        DBhelper dbHelper = new DBhelper(AllSurahNamesActivity.this);
         list = dbHelper.getAllSurah();    //Get Data from DB
        recyclerView = findViewById(R.id.recycleViewsurah);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(AllSurahNamesActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new All_Surah_nameAdapter(getApplicationContext(), list, T_index);

        recyclerView.setAdapter(adapter);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {

                    Intent intent = new Intent(AllSurahNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value", "0");
                    startActivity(intent);
                } else if (item.getItemId() == R.id.nav_FatehMuhammad) {
                    Intent intent = new Intent(AllSurahNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value", "1");
                    startActivity(intent);
                } else if (item.getItemId() == R.id.nav_MehmoodHassan) {

                    Intent intent = new Intent(AllSurahNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value", "2");
                    startActivity(intent);
                } else if (item.getItemId() == R.id.nav_DrMohsinKhan) {
                    Intent intent = new Intent(AllSurahNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value", "3");
                    startActivity(intent);
                } else if (item.getItemId() == R.id.nav_MuftiTakiUsmani) {
                    Intent intent = new Intent(AllSurahNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value", "4");
                    startActivity(intent);
                }

                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


}

