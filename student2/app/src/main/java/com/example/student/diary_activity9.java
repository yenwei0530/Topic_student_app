package com.example.student;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class diary_activity9 extends AppCompatActivity {

    int t1h,t1m,t3h,t3m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary9);
        getSupportActionBar().hide();//關閉標題列

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告TextView物件
        TextView t1 =findViewById(R.id.t1);
        TextView t3 =findViewById(R.id.t3);


        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告ImageView物件
        ImageView imageView=findViewById(R.id.imageView);
        ImageView imageView2=findViewById(R.id.imageView2);
        ImageView imageView3=findViewById(R.id.imageView3);

        //宣告EditText物件
        EditText edt1=findViewById(R.id.edt1);

        //ImageView點擊事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("開始時間");
                t3.setText("結束時間");
            }
        });

        //ImageView2點擊事件
        //Calendar 參考網址:http://denimpanell.blogspot.com/2018/01/android-studio-timepickerdialog.html
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                new TimePickerDialog(diary_activity9.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1.setText( hourOfDay + ":" + minute);
                    }
                }, hour, minute, false).show();
            }
        });

        //ImageView3點擊事件
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                new TimePickerDialog(diary_activity9.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t3.setText( hourOfDay + ":" + minute);
                    }
                }, hour, minute, false).show();
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(diary_activity9.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一頁點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至下一頁面
                Intent intent =new Intent(diary_activity9.this, diary_activity10.class);
                startActivity(intent);
            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                finish();
            }
        });

    }
}