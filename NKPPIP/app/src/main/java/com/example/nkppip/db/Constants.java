package com.example.nkppip.db;

public class Constants {
    public static final String EDIT = "edit";
    public static final String LIST_ITEM = "list_item";
    public static final String TABLE_NAME = "Receipt";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "desc";
    public static final String DB_NAME = "my_DB.DB";
    public static final int VERSION = 1;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS" +
            TABLE_NAME + "(" +  ID + "INTEGER PRIMARY KEY" + TITLE + "TEXT" +
            DESCRIPTION + "TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF NOT EXISTS" + TABLE_NAME;
}
