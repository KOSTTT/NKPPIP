package com.example.nkppip.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nkppip.adapter.ListItem;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public DbManager(Context context){
        this.context = context;
        dbHelper = new DbHelper(context);
    }
    public void openDb(){
        db = dbHelper.getWritableDatabase();
    }
    public void insertDb(String title, String desc){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.TITLE,title);
        contentValues.put(Constants.DESCRIPTION,desc);
        db.insert(Constants.TABLE_NAME,null,contentValues);
    }
    public List<ListItem> getFromDb(){
        List<ListItem> tempList = new ArrayList<>();
        Cursor cursor = db.query(Constants.TABLE_NAME,null,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            ListItem listItem = new ListItem();
            String title = cursor.getString(cursor.getColumnIndexOrThrow(Constants.TITLE));
            String desc = cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESCRIPTION));
            listItem.setTitle(title);
            listItem.setDesc(desc);
            tempList.add(listItem);
        }
        cursor.close();
        return tempList;
    }
    public void closeDb(){
        dbHelper.close();
    }
}
