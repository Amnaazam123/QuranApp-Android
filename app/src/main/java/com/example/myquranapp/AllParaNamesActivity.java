package com.example.myquranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AllParaNamesActivity extends AppCompatActivity  {
    QDH store;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<para> list;
    int T_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_para);
        store=new QDH();
        Intent i=getIntent();
        T_index = Integer.parseInt(i.getStringExtra("value"));
//        SearchView simpleSearchView=(SearchView)findViewById(R.id.simpleSearchViewPara);

        list =store.getAllPara();
        recyclerView = findViewById(R.id.recycleViewpara);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(AllParaNamesActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AllParaNameAdapter(getApplicationContext(),list,T_index) ;
        recyclerView.setAdapter(adapter);

        NavigationView navigationView = findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_home)
                {

                    Intent intent = new Intent(AllParaNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value","0");
                    startActivity(intent);
                }

                else if(item.getItemId()==R.id.nav_FatehMuhammad)
                {
                    Intent intent = new Intent(AllParaNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value","1");
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_MehmoodHassan)
                {

                    Intent intent = new Intent(AllParaNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value","2");
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_DrMohsinKhan)
                {
                    Intent intent = new Intent(AllParaNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value","3");
                    startActivity(intent);
                } else if(item.getItemId()==R.id.nav_MuftiTakiUsmani)
                {
                    Intent intent = new Intent(AllParaNamesActivity.this, FrontPageActivity.class);
                    intent.putExtra("value","4");
                    startActivity(intent);
                }

                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

}