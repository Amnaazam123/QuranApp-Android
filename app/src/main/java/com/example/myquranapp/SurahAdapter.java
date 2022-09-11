package com.example.myquranapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SurahAdapter extends ArrayAdapter<tayah>  {

    private int T_index;
    public SurahAdapter(@NonNull Context context, ArrayList<tayah> surah,int t_index) {
        super(context, 0, surah);
        this.T_index=t_index;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        tayah myclass = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surah_customized_view, parent, false);
        TextView ayat = convertView.findViewById(R.id.surahAyat);
        ayat.setText(String.valueOf( myclass.getArabicText()));
        TextView ayattrjama = convertView.findViewById(R.id.ayattrjama);
        if(T_index==0)
            ayattrjama.setText(String.valueOf( myclass.getFatehMuhammadJaland()));
        else if(T_index==1)
            ayattrjama.setText(String.valueOf( myclass.getFatehMuhammadJaland()));
        else if(T_index==2)
            ayattrjama.setText(String.valueOf( myclass.getDrMohsinKhan()));
        else if(T_index==3)
            ayattrjama.setText(String.valueOf( myclass.getMuftitakiUsmani()));
        else if(T_index==4)
            ayattrjama.setText(String.valueOf( myclass.getMuftitakiUsmani()));


//        Typeface typeface = getResources().getFont(R.font.noorehuda);
//        ayat.setTypeface(typeface);

        return convertView;
    }

}
