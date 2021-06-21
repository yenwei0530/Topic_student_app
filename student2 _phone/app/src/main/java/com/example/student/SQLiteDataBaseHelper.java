package com.example.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
    String TAG = SQLiteDataBaseHelper.class.getSimpleName();
    String TableName;
    public SQLiteDataBaseHelper(@Nullable Context context
            , @Nullable String name
            , @Nullable SQLiteDatabase.CursorFactory factory, int version, String TableName) {
        super(context, name, factory, version);
        this.TableName = TableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLTable = "CREATE TABLE IF NOT EXISTS student  ( " +
                "student_id varchar(11) PRIMARY KEY , " +
                "password varchar(50), " +
                "student_name varchar(10)," +
                "student_year varchar(5)," +
                "student_class varchar(5)," +
                "mom_year varchar(11)," +
                "father_year varchar(11)," +
                "birthday date," +
                "sex varchar(5)" +
                ");";

        db.execSQL(SQLTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TableName;
        db.execSQL(SQL);
    }

    //新增資料
    public void addData(String student_id, String password, String student_name, String student_year,String student_class,String mom_year,String father_year,String birthday,String sex) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("student_id", student_id);
        values.put("password", password);
        values.put("student_name", student_name);
        values.put("student_year", student_year);
        values.put("student_class", student_class);
        values.put("mom_year", mom_year);
        values.put("father_year", father_year);
        values.put("birthday", birthday);
        values.put("sex", sex);
        db.insert("student", null, values);
    }
    //刪除student
    public void deletestudent(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("student","1" ,null);
    }

    //判斷student帳號密碼
    public String checkstudent(String student_id,String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM  student"
                + " WHERE student_id =" + "'" + student_id + "'"
                + " AND password =" + "'" + password + "'", null);
        String count = " SELECT * FROM  student"
                + " WHERE student_id =" + "'" + student_id + "'"
                + " AND password =" + "'" + password + "'";
        if (c.moveToNext()) {
            count = "T";
        }else{
            count = "F";
        }
        return count;
    }


    //顯示所有資料
    public ArrayList<HashMap<String, String>> showAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + TableName, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            String id = c.getString(0);
            String name = c.getString(1);
            String phone = c.getString(2);
            String hobby = c.getString(3);
            String elseInfo = c.getString(4);

            hashMap.put("id", id);
            hashMap.put("name", name);
            hashMap.put("phone", phone);
            hashMap.put("hobby", hobby);
            hashMap.put("elseInfo", elseInfo);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    //以興趣篩選資料
    public ArrayList<HashMap<String, String>> searchByHobby(String getHobby) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + TableName
                + " WHERE Hobby =" + "'" + getHobby + "'", null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            String id = c.getString(0);
            String name = c.getString(1);
            String phone = c.getString(2);
            String hobby = c.getString(3);
            String elseInfo = c.getString(4);

            hashMap.put("id", id);
            hashMap.put("name", name);
            hashMap.put("phone", phone);
            hashMap.put("hobby", hobby);
            hashMap.put("elseInfo", elseInfo);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    //修改資料(簡單)
    public void modifyEZ(String id, String name, String phone, String hobby, String elseInfo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Phone", phone);
        values.put("Hobby", hobby);
        values.put("ElseInfo", elseInfo);
        db.update(TableName, values, "_id = " + id, null);
    }


    //以id刪除資料(簡單)
    public void deleteByIdEZ(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TableName,"_id = " + id,null);
    }

    //檢查資料表狀態，若無指定資料表則新增
    public void chickTable(){
        Cursor cursor = getWritableDatabase().rawQuery(
                "select DISTINCT tbl_name from sqlite_master where tbl_name = '" + TableName + "'", null);
        if (cursor != null) {
            if (cursor.getCount() == 0)
                getWritableDatabase().execSQL("CREATE TABLE IF NOT EXISTS " + TableName + "( " +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT, " +
                        "Phone TEXT," +
                        "Hobby TEXT," +
                        "ElseInfo TEXT" +
                        ");");
            cursor.close();
        }


    }
}
