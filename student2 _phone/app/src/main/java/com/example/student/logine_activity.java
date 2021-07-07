package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.HashMap;

public class logine_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();//關閉標題列
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫


        //刪除student
        //mDBHelper.deletestudent();

        //從伺服器抓學生資料到sqlite
        /*new Thread(new Runnable(){
            @Override
            public void run(){
                MysqlCon con = new MysqlCon();
                con.run();
                arrayList=con.getstudent();
                Log.v("OK", String.valueOf(arrayList));
                for (int i=0;i<=arrayList.size()-1;i++)
                {
                    mDBHelper.addData(arrayList.get(i).get("student_id"),arrayList.get(i).get("password"),arrayList.get(i).get("student_name"),arrayList.get(i).get("student_year"),arrayList.get(i).get("student_class"),arrayList.get(i).get("mom_year"),arrayList.get(i).get("father_year"),arrayList.get(i).get("birthday"),arrayList.get(i).get("sex"));
                }
            }
        }).start();*/

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button sumbit=findViewById(R.id.sumbit);


        //宣告EditText物件
        EditText UserId=findViewById(R.id.UserId);
        EditText Password=findViewById(R.id.Password);


        //登入觸發事件
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if( mDBHelper.checkstudent(UserId.getText().toString(),Password.getText().toString())=="T"){
                    gv.setuser(UserId.getText().toString());
                    gv.setpassword(Password.getText().toString());
                    arrayList = mDBHelper.student(UserId.getText().toString());
                    gv.setname(arrayList.get(0).get("name"));
                    gv.setsex(arrayList.get(0).get("sex"));
                    //上次心情
                    new Thread(new Runnable(){
                        @Override
                        public void run(){
                            MysqlCon con = new MysqlCon();
                            con.run();
                            //學生資料
                            gv.setupmood(con.getupmood(UserId.getText().toString()));
                        }
                    }).start();
                    //判斷是否填寫過第一次社會適應量表
                    if( arrayList.get(0).get("MAX_DATE").equals("0000-00-00")){
                        Intent intent =new Intent(logine_activity.this,scale0_activity.class);
                        startActivity(intent);
                    }else{
                        Intent intent =new Intent(logine_activity.this,main_activity.class);
                        startActivity(intent);
                    }

                }else {
                    Toast.makeText(logine_activity.this, "帳號密碼錯誤!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}