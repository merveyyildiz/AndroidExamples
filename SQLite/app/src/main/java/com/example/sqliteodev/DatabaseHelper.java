package com.example.sqliteodev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public  class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "CONTACT.DB";
    public final static String TABLE_NAME = "CONTACTS";
    public final static String COL_ID = "ID";
    public final static String COL_NAME_SURNAME = "İsimSoyisim";
    public final static String COL_TEL = "TelefonNumarası";
    SQLiteDatabase database;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "(ID  INTEGER PRIMARY KEY AUTOINCREMENT, İsimSoyisim TEXT NOT  NULL, TelefonNumarası TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_QUERY);
        this.database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String UPGRADE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(UPGRADE_QUERY);
        this.onCreate(db);
    }

    public List<String> ListPerson() {
        List<String> value = new ArrayList<String>();
        database = this.getReadableDatabase();
        try {
            String query = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = database.rawQuery(query, null);
            while (cursor.moveToNext()) {
                value.add(cursor.getString(1));
            }
        } catch (Exception e) {
        }
        database.close();
        return value;
    }

    public boolean insertContact(String nameSurname, String numara) {
        database = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(COL_NAME_SURNAME, nameSurname);
        value.put(COL_TEL, numara);
        Long result = database.insert(TABLE_NAME, null, value);
        database.close();
        if (result == -1)
            return false;
        else
            return true;
    }

    public void deleteContact(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_NAME, COL_NAME_SURNAME + " = '" + name + "'" , null);
        } catch (Exception e) {
        }

        db.close();
    }

    public void updateConcat(String gelen, String ad, String tel) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues value = new ContentValues();
            value.put(COL_NAME_SURNAME, ad);
            value.put(COL_TEL, tel);
            db.update(TABLE_NAME, value, COL_NAME_SURNAME + " = '" + gelen + "'", null);
        } catch (Exception e) {

        }
        db.close();

    }
    public String findTel(String name){
        database=this.getReadableDatabase();
        String tel="";
        String query="SELECT * FROM "+TABLE_NAME+ " WHERE İsimSoyisim = '"+ name+"'";
        Cursor cursor=database.rawQuery(query,null);
        if(cursor.moveToFirst()){
            tel=cursor.getString(2);
        }
        return tel;
    }
}