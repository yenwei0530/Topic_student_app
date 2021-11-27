package com.example.student;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mood_ter_step1_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step1);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告TextView物件
        TextView t1=findViewById(R.id.t1);

        if(gv.getabc().equals("T")){
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //語音
        MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_ter_step1);
        mp.start();

       /* //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);




        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });*/

        //下一步點擊事件

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_step1_activity.this, mood_ter_step1_1_activity.class);
                startActivity(intent);
                mp.pause();
                mp.release();
            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                finish();
                mp.pause();
                mp.release();
            }
        });



    }
}