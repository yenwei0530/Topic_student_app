package com.example.student;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class student_information_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        getSupportActionBar().hide();//關閉標題列

        //宣告Button物件
        Button exit=findViewById(R.id.exit);

        //宣告ImageView物件
        ImageView img1=findViewById(R.id.img1);

        //宣告TextView物件
        TextView txt_day =findViewById(R.id.txt_day);

        //爸爸學歷spinner設定
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final String[] lunch = {"國中", "高中", "大學", "研究所", "碩士","博士"};
        ArrayAdapter<String> lunchList = new ArrayAdapter<>(student_information_activity.this,
                R.layout.myspinner,
                lunch);spinner.setAdapter(lunchList);

        //媽媽學歷spinner設定
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner2.setAdapter(lunchList);

        //性別spinner設定
        Spinner spinner0 = (Spinner)findViewById(R.id.spinner0);
        final String[] lunch2 = {"男", "女"};
        ArrayAdapter<String> lunchList2 = new ArrayAdapter<>(student_information_activity.this,
                R.layout.myspinner,
                lunch2);spinner0.setAdapter(lunchList2);

        //日歷點擊事件
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(student_information_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txt_day.setText(year+"-"+month+"-"+dayOfMonth);
                        txt_day.setVisibility(View.VISIBLE);
                    }
                },year,month,day).show();
            }
        });

        //返回點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉頁面
                finish();
            }
        });
    }
}