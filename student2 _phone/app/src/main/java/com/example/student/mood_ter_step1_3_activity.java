package com.example.student;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mood_ter_step1_3_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ter_step1_3);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告TextView物件
        TextView txt1=findViewById(R.id.txt1);
        TextView t1=findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView t3=findViewById(R.id.t3);
        TextView t4=findViewById(R.id.t4);
        TextView t5=findViewById(R.id.t5);
        TextView t6=findViewById(R.id.t6);
        TextView t7=findViewById(R.id.t7);
        TextView t8=findViewById(R.id.t8);
        TextView t9=findViewById(R.id.t9);
        TextView t10=findViewById(R.id.t10);

        if(gv.getabc().equals("T")){
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));

        }else {
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //語音
        MediaPlayer mp = MediaPlayer.create(this, R.raw.mood_ter_step1_3);
        mp.start();

        //預設呼吸變急
        t1.setBackgroundColor(Color.GREEN);

        //呼吸變急點擊事件
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t1.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t1.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t1.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //心跳變快點擊事件
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t2.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t2.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t2.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //流汗增加點擊事件
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t3.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t3.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t3.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //臉部變紅點擊事件
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t4.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t4.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t4.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //肌肉變緊張點擊事件
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t5.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t5.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t5.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //聲音變大聲或尖銳點擊事件
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t6.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t6.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t6.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //流淚點擊事件
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t7.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t7.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t7.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //發抖點擊事件
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t8.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t8.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t8.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //想嘔吐點擊事件
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t9.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t9.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t9.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //胃覺得不舒服點擊事件
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取TextView顏色背景
                ColorDrawable viewColor = (ColorDrawable) t10.getBackground();
                int colorId = viewColor.getColor();
                //如果是綠色就變白色
                if(colorId==-16711936){
                    t10.setBackgroundColor(Color.WHITE);
                }
                //如果是白色就變綠色
                if(colorId==-1){
                    t10.setBackgroundColor(Color.GREEN);
                }

            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mood_ter_step1_3_activity.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
                mp.pause();
            }
        });

        //下一步點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable viewColor = (ColorDrawable) t1.getBackground();
                ColorDrawable viewColor2 = (ColorDrawable) t2.getBackground();
                ColorDrawable viewColor3 = (ColorDrawable) t3.getBackground();
                ColorDrawable viewColor4 = (ColorDrawable) t4.getBackground();
                ColorDrawable viewColor5 = (ColorDrawable) t5.getBackground();
                ColorDrawable viewColor6 = (ColorDrawable) t6.getBackground();
                ColorDrawable viewColor7 = (ColorDrawable) t7.getBackground();
                ColorDrawable viewColor8 = (ColorDrawable) t8.getBackground();
                ColorDrawable viewColor9 = (ColorDrawable) t9.getBackground();
                ColorDrawable viewColor10 = (ColorDrawable) t10.getBackground();
                int colorId = viewColor.getColor();
                int colorId2 = viewColor2.getColor();
                int colorId3 = viewColor3.getColor();
                int colorId4 = viewColor4.getColor();
                int colorId5 = viewColor5.getColor();
                int colorId6 = viewColor6.getColor();
                int colorId7= viewColor7.getColor();
                int colorId8 = viewColor8.getColor();
                int colorId9 = viewColor9.getColor();
                int colorId10 = viewColor10.getColor();

                if(colorId==-1){
                    //將答案存入全域變數
                    gv.setter1_3("");
                }
                if(colorId==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3("呼吸變急");
                }
                if(colorId2==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",心跳變快");
                }
                if(colorId3==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",流汗增加");
                }
                if(colorId4==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",臉部變紅");
                }
                if(colorId5==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",肌肉變緊張");
                }
                if(colorId6==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",聲音變大聲或尖銳");
                }
                if(colorId7==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",流淚");
                }
                if(colorId8==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",發抖");
                }
                if(colorId9==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",想嘔吐");
                }
                if(colorId10==-16711936){
                    //將答案存入全域變數
                    gv.setter1_3(gv.getter1_3()+",胃覺得不舒服");
                }
                //跳至下一頁面
                Intent intent =new Intent(mood_ter_step1_3_activity.this, mood_ter_step1_4_activity.class);
                startActivity(intent);
                mp.pause();
            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                finish();
                mp.pause();
            }
        });



    }
}