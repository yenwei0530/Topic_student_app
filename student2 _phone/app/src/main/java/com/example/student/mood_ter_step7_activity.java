package com.example.student;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class mood_ter_step7_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step7);
        getSupportActionBar().hide();//關閉標題列
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫

        //宣告TextView物件
        CardView card1=findViewById(R.id.card1);
        CardView card2=findViewById(R.id.card2);
        CardView card3=findViewById(R.id.card3);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView t1=findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView t3=findViewById(R.id.t3);
        TextView t4=findViewById(R.id.t4);

        if(gv.getabc().equals("T")){
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }
        //語音
        MediaPlayer mp = MediaPlayer.create(this, R.raw. mood_ter_step7);
        mp.start();

        arrayList = mDBHelper.student(gv.getuser());


        //寫入資料
        new Thread(new Runnable(){
            @Override
            public void run(){
                MysqlCon con = new MysqlCon();
                con.insertthermometer(gv.getuser(),gv.getter1_1(),gv.getter1_2(),gv.getter1_3(),gv.getter1_4(),gv.getter3_1(),gv.getter6_1());
            }
        }).start();

        //定義好時間字串的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //將字串轉成Date型
        Date dt = null;
        try {
            dt = sdf.parse(arrayList.get(0).get("MAX_DATE"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //新增一個Calendar,並且指定時間
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        int add =Integer.parseInt(arrayList.get(0).get("adaptation_scale"))*7;
        Log.v("DB", "寫入資料完成：" + add);
        calendar.add(Calendar.DATE, add);//日期+2
        Date tdt=calendar.getTime();//取得加減過後的Date

        //依照設定格式取得字串
        String time=sdf.format(tdt);
        //系統時間
        String date = sdf.format(new java.util.Date());

        try {
            Date sdate=sdf.parse(time);//第一個日期（字符串）
            Date edate=sdf.parse(date);//第二個日期（字符串）
        //如果時間到跳出前往社會適應量表
        if(sdate.getTime()<=edate.getTime()){
            //實體化layout
            LayoutInflater inflater=getLayoutInflater();
            final View textEntryView = inflater.inflate(R.layout.custom_dialog4, null);

            //用setView把layout放進去
            AlertDialog.Builder builder = new AlertDialog.Builder(mood_ter_step7_activity.this);
            builder.setView(textEntryView);

            //創建一個Dialog
            AlertDialog alert = builder.create();

            //layout中Button結束事件
            Button finsh = (Button) textEntryView.findViewById(R.id.finsh);
            finsh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(mood_ter_step7_activity.this,scale0_activity.class);
                    startActivity(intent);
                }
            });
            alert.show();

         }
        } catch (ParseException e) {
            e.printStackTrace();
        }



        //拼圖遊戲觸發事件
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至拼圖遊戲
                Intent intent =new Intent(mood_ter_step7_activity.this, puzzle_start_activity.class);
                startActivity(intent);
                mp.pause();
            }
        });

        //回主頁觸發事件
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(mood_ter_step7_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
                mp.pause();
            }
        });

        //情緒遊戲觸發事件
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至心情溫度計頁面
                Intent intent =new Intent(mood_ter_step7_activity.this, mood_game_activity.class);
                startActivity(intent);
                mp.pause();
            }
        });



    }
}