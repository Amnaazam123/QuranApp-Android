package com.example.myquranapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class paraAdapter extends RecyclerView.Adapter<paraAdapter.MyVH>{
    private Context _context;
    private ArrayList<tayah> ayat;

  private int T_index;
    public paraAdapter(Context c,ArrayList<tayah> t,int ti) {
        this.ayat = t;
        this._context = c;
        this.T_index=ti;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.para_customized_view, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=ayat.get(position);
        holder.para.setText(holder.data.getArabicText());
        if(T_index==0)
            holder.paratrjama.setText(String.valueOf( holder.data.getFatehMuhammadJaland()));
        else if(T_index==1)
            holder.paratrjama.setText(String.valueOf( holder.data.getFatehMuhammadJaland()));
        else if(T_index==2)
            holder.paratrjama.setText(String.valueOf( holder.data.getDrMohsinKhan()));
        else if(T_index==3)
            holder.paratrjama.setText(String.valueOf( holder.data.getMuftitakiUsmani()));
        else if(T_index==4)
            holder.paratrjama.setText(String.valueOf( holder.data.getMuftitakiUsmani()));

        int p=position;
        tayah parah=ayat.get(position);

    }

    @Override
    public int getItemCount() {
        return ayat.size();
    }
    public class MyVH extends RecyclerView.ViewHolder {
        TextView para;
        TextView paratrjama;
        TextView Id;
        tayah data;
        public MyVH(@NonNull View itemView) {
            super(itemView);

            para = itemView.findViewById(R.id.paraname2);
            paratrjama = itemView.findViewById(R.id.paratrjama);

        }

    }
}
