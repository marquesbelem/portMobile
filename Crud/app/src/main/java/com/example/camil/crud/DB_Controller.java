package com.example.camil.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by camil on 29/11/2016.
 */
public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TESTE.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE JOGOS( ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT UNIQUE, LASTNAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS JOGOS;");
        onCreate(sqLiteDatabase);
    }

    public void insert_jogo(String firstname, String lastname){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRSTNAME",firstname);
        contentValues.put("LASTNAME",lastname);
        this.getWritableDatabase().insertOrThrow("JOGOS","",contentValues);
    }

    public void delete_jogo(String firstname){
        this.getWritableDatabase().delete("JOGOS","FIRSTNAME='"+firstname+"'",null);
    }

    public void update_jogo(String old_firstname, String new_firtname){
        this.getWritableDatabase().execSQL("UPDATE JOGOS SET FIRSTNAME='"+new_firtname+"' WHERE FIRSTNAME='"+old_firstname+"'");
    }

    public void list_all_jogos(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM JOGOS",null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1) +" "+cursor.getString(2));
        }

    }
}
