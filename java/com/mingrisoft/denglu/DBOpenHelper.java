package com.mingrisoft.denglu;

import androidx.annotation.Nullable;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase db;
    //private SQLiteDatabase db;

    public DBOpenHelper(@Nullable Context context) {
        super(context, "db_map", null, 1);
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT," +
                "phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public void add(String name, String password) {
        db.execSQL("INSERT INTO user (name,password) VALUES(?,?)", new Object[]{name, password});
    }

        public static void addphone1(String phone) {
        db.execSQL("INSERT INTO user (phone) VALUES(?)", new Object[]{phone});
    }
//    public static void addphone(String name, String phone) {
//        Cursor cursor = db.rawQuery("select * from user where name=?", new String[]{name});
//        if (cursor.getCount() == 1) {
//            cursor.moveToNext();
//            db.execSQL("INSERT INTO user (phone) VALUES(?)", new Object[]{phone});
//        }
//    }

    public void delete(String name, String password) {
        db.execSQL("DELETE FROM user WHERE name = AND password =" + name + password);
    }

    public void updata(String password) {
        db.execSQL("UPDATE user SET password = ?", new Object[]{password});
    }

    //    public String getpassword(String name){
//        Cursor cursor = db.query("user",new String[]{"password"},"name=?",new String[]{name},null,null,"name DESC");
//        if(cursor.getCount() == 1){
//            return cursor.getString(0);
//        }
//        else{
//            return "";
//        }
//    }
    // public String getpassword(String password){
    //        db.query('user','name',);
    //     return  password;
    // }
    public ArrayList<User> getall() {
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.query("user", null, null, null, null, null, "name DESC");
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new User(name, password, cursor.getString(cursor.getColumnIndex("phone"))));
        }
        return list;
    }
}

//    public User getUser(String name) {
//        //Cursor cursor = db.query("user",null,"name=?",new String[]{name},null,null,"name DESC");
//        Cursor cursor = db.rawQuery("select * from user where name=?", new String[]{name});
//        if (cursor.getCount() == 1) {
//            cursor.moveToNext();
//            User user = new User(cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("password")),cursor.getString(cursor.getColumnIndex("phone")));
//            return user;
//        } else {
//            return null;
//        }
//    }
//}
//    public User getpassword(String passwod){
//        //Cursor cursor = db.query("user",null,"name=?",new String[]{name},null,null,"name DESC");
//        Cursor cursor = db.rawQuery("select * from user where password=?", new String[]{passwod});
//        if(cursor.getCount()==1){
//            cursor.moveToNext();
//            User user = new User(cursor.getString(cursor.getColumnIndex("name")),cursor.getString(cursor.getColumnIndex("password")));
//            return user;
//        }
//        else{
//            return null;
//        }
//    }
//}
