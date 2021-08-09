package com.example.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                "id INTEGER PRIMARY KEY AUTOINCREMENT  , " +
                "student_id varchar(11)  , " +
                "user_id varchar(50) , " +
                "password varchar(50), " +
                "student_name varchar(10)," +
                "student_year varchar(5)," +
                "student_class varchar(5)," +
                "mom_year varchar(11)," +
                "father_year varchar(11)," +
                "birthday date," +
                "sex varchar(5)," +
                "adaptation_scale varchar(2)," +
                "MAX_DATE varchar(50)" +
                ");";

        String SQLTable2 = "CREATE TABLE IF NOT EXISTS video  ( " +
                "video_id varchar(11)  PRIMARY KEY , " +
                "student_id varchar(20), " +
                "video text," +
                "video_url text" +
                ");";

        db.execSQL(SQLTable);

        db.execSQL(SQLTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TableName;
        db.execSQL(SQL);
    }

    //新增資料
    public void addData(String student_id,String user_id, String password, String student_name, String student_year,String student_class,String mom_year,String father_year,String birthday,String sex,String adaptation_scale,String MAX_DATE) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("student_id", student_id);
        values.put("user_id", user_id);
        values.put("password", password);
        values.put("student_name", student_name);
        values.put("student_year", student_year);
        values.put("student_class", student_class);
        values.put("mom_year", mom_year);
        values.put("father_year", father_year);
        values.put("birthday", birthday);
        values.put("sex", sex);
        values.put("adaptation_scale", adaptation_scale);
        if (MAX_DATE != null && !MAX_DATE.equals("")) {
            values.put("MAX_DATE", MAX_DATE);
        }else{
            values.put("MAX_DATE", "0000-00-00");
        }

        db.insert("student", null, values);
    }
    //新增影片
    public void addvideo(String video_id, String student_id, String video, String video_url) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("video_id", video_id);
        values.put("student_id", student_id);
        values.put("video", video);
        values.put("video_url", video_url);
        db.insert("video", null, values);
    }
    //刪除student
    public void deletestudent(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("student","1" ,null);
    }
    //刪除video
    public void deletevideo(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("video","1" ,null);
    }

    //以videoid刪除資料(簡單)
    public void deletevideoid(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TableName,"video_id = " + id,null);
    }
    //修改影片名稱(簡單)
    public void updatevideo2(String id, String nmae) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("video",nmae);
        db.update(TableName, cv, "video_id = ?", new String[]{id});
    }

    //判斷student帳號密碼
    public String checkstudent(String user_id,String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM  student"
                + " WHERE user_id =" + "'" + user_id + "'"
                + " AND password =" + "'" + password + "'", null);
        String count = "";
        if (c.moveToNext()) {
            count = "T";
        }else{
            count = "F";
        }
        return count;
    }

    //取得student
    public ArrayList<HashMap<String, String>> student(String user_id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM  student"
                + " WHERE user_id =" + "'" + user_id + "'", null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            String student_id = c.getString(1);
            String password = c.getString(3);
            String name = c.getString(4);
            String sex = c.getString(10);
            String adaptation_scale = c.getString(11);
            String birthday = c.getString(9);
            String MAX_DATE = c.getString(12);

            hashMap.put("student_id", student_id);
            hashMap.put("name", name);
            hashMap.put("password", password);
            hashMap.put("sex", sex);
            hashMap.put("birthday", birthday);
            hashMap.put("adaptation_scale", adaptation_scale);
            hashMap.put("MAX_DATE", MAX_DATE);

            arrayList.add(hashMap);
        }
        return arrayList;
    }
    //取得video
    public ArrayList<HashMap<String, String>> video(String student_id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM  video"
                + " WHERE student_id =" + "'" + student_id + "'", null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            String video_id = c.getString(0);
            String video = c.getString(2);
            String video_url = c.getString(3);

            hashMap.put("video_id", video_id);
            hashMap.put("video", video);
            hashMap.put("video_url", video_url);

            arrayList.add(hashMap);
        }
        return arrayList;
    }

    //修改社會適應量表時間(簡單)
    public void updatescale(String id, String MAX_DATE1) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("MAX_DATE",MAX_DATE1);
        db.update(TableName, cv, "user_id = ?", new String[]{id});
    }

    //修改資料(簡單)
    public void updatestudent(String id, String student_id,String name,String sex,String birthday) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("student_id",student_id);
        cv.put("student_name",name);
        cv.put("sex",sex);
        cv.put("birthday",birthday);
        db.update(TableName, cv, "user_id = ?", new String[]{id});
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
