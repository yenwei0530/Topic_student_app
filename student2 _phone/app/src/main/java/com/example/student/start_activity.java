package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class start_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料

    private  static  int timeout=1800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.start);
        getSupportActionBar().hide();//關閉標題列

        AlphaAnimation fadeout = new AlphaAnimation(1,0);
        fadeout.setInterpolator(new AccelerateInterpolator());
        fadeout.setStartOffset(500);
        fadeout.setDuration(1800);

        ImageView image = findViewById(R.id.imageView6);

        image.setAnimation(fadeout);

        //----------寫資料-----------

        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //刪除student
                mDBHelper.deletestudent();

                //從伺服器抓學生資料到sqlite
                new Thread(new Runnable(){
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
                }).start();

                Intent intent =new Intent(start_activity.this,logine_activity.class);
                startActivity(intent);
                finish();
            }
        },timeout);
    }

}