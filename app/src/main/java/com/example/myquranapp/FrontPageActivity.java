package com.example.myquranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class FrontPageActivity extends AppCompatActivity {

    int T_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_frontpage);
        TextView molvi=findViewById(R.id.molvi);
       molvi.setText("Fateh Muhammad");
        Intent i=getIntent();
        T_index = Integer.parseInt(i.getStringExtra("value"));

        Button surahIndex= findViewById(R.id.surahIndex);
        Button paraIndex=findViewById(R.id.paraIndex);

        surahIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent surahIndex=new Intent(FrontPageActivity.this,AllSurahNamesActivity.class);
                surahIndex.putExtra("value",String.valueOf(T_index));
                startActivity(surahIndex);
            }
        });

        paraIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent surahIndex=new Intent(FrontPageActivity.this,AllParaNamesActivity.class);
                surahIndex.putExtra("value",String.valueOf(T_index));
                startActivity(surahIndex);
            }
        });


        NavigationView navigationView = findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {


                } else if (item.getItemId() == R.id.nav_FatehMuhammad) {
                    molvi.setText("Fateh Muhammad");
                    T_index=1;


                } else if (item.getItemId() == R.id.nav_MehmoodHassan) {
                    molvi.setText("Mehmood Hassan");
                    T_index=2;


                }else if (item.getItemId() == R.id.nav_sura) {

                    Intent intent = new Intent(FrontPageActivity.this, AllSurahNamesActivity.class);
                    intent.putExtra("value", "1");
                    startActivity(intent);

                }
                else if (item.getItemId() == R.id.nav_para) {
                    Intent intent = new Intent(FrontPageActivity.this, AllParaNamesActivity.class);
                    intent.putExtra("value", "1");
                    startActivity(intent);

                }
                else if (item.getItemId() == R.id.nav_DrMohsinKhan) {
                    molvi.setText("Dr Mohsin Khan");
                    T_index=3;


                } else if (item.getItemId() == R.id.nav_MuftiTakiUsmani) {
                    molvi.setText("Mufti Taki Usmani");
                    T_index=4;

                }

                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


}