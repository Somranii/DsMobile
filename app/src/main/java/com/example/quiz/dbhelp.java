package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelp extends SQLiteOpenHelper {
    public dbhelp(Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table game(name TEXT primary key,score TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("drop table if exists game");
    }
public boolean insertdata(String name , String score){
SQLiteDatabase db=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
contentValues.put("name",name);
contentValues.put("score",score);
long res=db.insert("game",null,contentValues);
if (res==-1) return false;
else
    return true ;
}
public Cursor showdata() {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor c = db.rawQuery("Select * from game", null);
    return c;
}


}
