package com.example.myquranapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DBNAME = "QuranDb.db";
    public static final int DBVERSION = 1;
    public static final String TABLE_ITEM = "tsurah";
    SQLiteDatabase mDB;

    public DBhelper(Context context) {
        super(context,DBNAME,null,DBVERSION);
        if (!ifDBExists(context)) {
            if (!copyDBFromAssets(context)) {
                throw new RuntimeException("Failed to Copy Database From Assets Folder");
            }
        }
        mDB = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    private boolean copyDBFromAssets(Context context) {
        Log.d("CPYDBINFO","Starting attemtpt to cop database from the assets file.");
        String DBPATH = "data/data/com.example.myquranapp/databases/QuranDb.db";
        InputStream
                is;
        OutputStream
                os;
        int buffer_size = 8192;
        int length = buffer_size;
        long bytes_read = 0;
        long bytes_written = 0;
        byte[] buffer = new byte[length];

        try {

            is = context.getAssets().open(DBNAME);
        } catch (IOException e) {
            Log.e("CPYDB FAIL - NO ASSET","Failed to open the Asset file " + DBNAME);
            e.printStackTrace();
            return false;
        }

        try {
            os = new FileOutputStream(DBPATH);
        } catch (IOException e) {
            Log.e("CPYDB FAIL - OPENDB","Failed to open the Database File at " + DBPATH);
            e.printStackTrace();
            return false;
        }
        Log.d("CPYDBINFO","Initiating copy from asset file" + DBNAME + " to " + DBPATH);
        while (length >= buffer_size) {
            try {
                length = is.read(buffer,0,buffer_size);
            } catch (IOException e) {
                Log.e("CPYDB FAIL - RD ASSET",
                        "Failed while reading in data from the Asset. " +
                                String.valueOf(bytes_read) +
                                " bytes read successfully."
                );
                e.printStackTrace();
                return false;
            }
            bytes_read = bytes_read + length;
            try {
                os.write(buffer,0,buffer_size);
            } catch (IOException e) {
                Log.e("CPYDB FAIL - WR ASSET","failed while writing Database File " +
                        DBPATH +
                        ". " +
                        String.valueOf(bytes_written) +
                        " bytes written successfully.");
                e.printStackTrace();
                return false;

            }
            bytes_written = bytes_written + length;
        }
        Log.d("CPYDBINFO",
                "Read " + String.valueOf(bytes_read) + " bytes. " +
                        "Wrote " + String.valueOf(bytes_written) + " bytes."
        );
        try {
            os.flush();
            is.close();
            os.close();
        } catch (IOException e ) {
            Log.e("CPYDB FAIL - FINALISING","Failed Finalising Database Copy. " +
                    String.valueOf(bytes_read) +
                    " bytes read." +
                    String.valueOf(bytes_written) +
                    " bytes written."
            );
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private boolean ifDBExists(Context context) {
        String dbparent = context.getDatabasePath(DBNAME).getParent();
        File f = context.getDatabasePath(DBNAME);
        if (!f.exists()) {
            Log.d("NODB MKDIRS","Database file not found, making directories."); //<<<< remove before the App goes live.
            File d = new File(dbparent);
            d.mkdirs();
            //return false;
        }
        return f.exists();
    }
    public ArrayList<tsurah> getAllSurah(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + "tsurah", null);

        ArrayList<tsurah> ArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {

             ArrayList.add(new tsurah(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            } while (cursor.moveToNext());

        }

        cursor.close();
        return ArrayList;
    }

    public ArrayList<tayah> Surah(int index){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT *" + " FROM " + "tayah" + " WHERE " + "SuraID" + " = '" + index + "'";
        Cursor data = db.rawQuery(query, null);

        ArrayList<tayah> surah = new ArrayList<>();

        if (data.moveToFirst()) {
            do {
                surah.add(new tayah(data.getInt(0), data.getInt(1), data.getInt(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7),data.getInt(8),data.getInt(9),data.getInt(10)));
            } while (data.moveToNext());

        }
        data.close();
        return  surah;
    }

    public ArrayList<tayah> Para(int index){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT *" + " FROM " + "tayah" + " WHERE " + "ParaID" + " = '" + index + "'";
        Cursor data = db.rawQuery(query, null);

        ArrayList<tayah> para = new ArrayList<>();

        if (data.moveToFirst()) {
            do {
                para.add(new tayah(data.getInt(0), data.getInt(1), data.getInt(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7),data.getInt(8),data.getInt(9),data.getInt(10)));
            } while (data.moveToNext());

        }
        data.close();
        return  para;
    }
}
