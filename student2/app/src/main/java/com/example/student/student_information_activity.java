package com.example.student;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
        //Button save=findViewById(R.id.save);

        //宣告ImageView物件
        //ImageView img1=findViewById(R.id.img1);

        //宣告TextView物件
        //TextView txt_day =findViewById(R.id.txt_day);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Switch物件
        Switch switch_Below=findViewById(R.id.switch_Below);

        //宣告TextView物件
        TextView id=findViewById(R.id.id);
        id.setText(gv.getuser());
        TextView password=findViewById(R.id.password);
        password.setText(gv.getpassword());
        TextView name=findViewById(R.id.name);
        name.setText(gv.getname());
        TextView name2=findViewById(R.id.name2);
        name2.setText(gv.getname());
        TextView sex=findViewById(R.id.sex);
        sex.setText(gv.getsex());
        TextView t1=findViewById(R.id.t1);


        /*//爸爸學歷spinner設定
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
                lunch2);spinner0.setAdapter(lunchList2);*/

        //日歷點擊事件
        /*img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(student_information_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        txt_day.setText(year+"-"+month+"-"+dayOfMonth);
                        txt_day.setVisibility(View.VISIBLE);
                    }
                },year,month,day).show();
            }
        });*/

        switch_Below.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    gv.setabc("T");
                    t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                }else{
                    gv.setabc("F");
                    t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                }
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

        //save點擊事件
        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "完成儲存!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                finish();
            }
        });*/
    }
}