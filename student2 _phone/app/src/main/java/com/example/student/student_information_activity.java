package com.example.student;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class student_information_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        getSupportActionBar().hide();//關閉標題列
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();


        //宣告Button物件
        Button exit=findViewById(R.id.exit);
        Button save=findViewById(R.id.save);

        //宣告ImageView物件
        ImageView img1=findViewById(R.id.img1);

        //宣告TextView物件
        //TextView txt_day =findViewById(R.id.txt_day);
        TextView point =findViewById(R.id.point);
        new Thread(new Runnable(){
            @Override
            public void run(){
                MysqlCon con = new MysqlCon();
                con.run();
                int data = Integer.parseInt(con.getthermometercount(gv.getuser()));
                int data2 = Integer.parseInt(con.getdiarycount(gv.getuser()));
                int data3=0;
                if (con.getprizecount(gv.getuser()) != null && !con.getprizecount(gv.getuser()).equals("")) {
                    data3 = Integer.parseInt(con.getprizecount(gv.getuser()));
                }

                String dd =String.valueOf(data+data2-data3);
                //點數
                point.post(new Runnable() {
                    public void run() {
                        point.setText(dd);
                    }
                });
            }
        }).start();
        TextView upmood =findViewById(R.id.upmood);
        //上次心情
        if (gv.getupmood() != null && !gv.getupmood().equals("")) {
            upmood.setText(gv.getupmood());
        }else {
            upmood.setText("無紀錄");
        }


        //宣告Switch物件
        Switch switch_Below=findViewById(R.id.switch_Below);

        //宣告TextView物件
        EditText id=findViewById(R.id.id);
        id.setText(gv.getstudentid());
        TextView password=findViewById(R.id.password);
        password.setText(gv.getuser());
        EditText name2=findViewById(R.id.name2);
        name2.setText(gv.getname());
        TextView txt_day=findViewById(R.id.txt_day);
        txt_day.setText(gv.getbirthday());

        TextView t1=findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView t3=findViewById(R.id.t3);
        TextView t4=findViewById(R.id.t4);
        TextView t6=findViewById(R.id.t6);
        TextView t7=findViewById(R.id.t7);

        //宣告RadioGroup物件
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton boys= (RadioButton) findViewById(R.id.boys);
        RadioButton girls= (RadioButton) findViewById(R.id.girls);
        final String[] sex = {"男"};
        if(gv.getsex().equals("男")){
            boys.setChecked(true);
        }else {
            girls.setChecked(true);
        }



        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                switch(checkedId){
                    case R.id.boys:
                        sex[0] ="男";break;
                    case R.id.girls:
                        sex[0] ="女";break;
                }

            }
        });


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
                        month=month+1;
                        txt_day.setText(year+"-"+month+"-"+dayOfMonth);
                        txt_day.setVisibility(View.VISIBLE);
                    }
                },year,month,day).show();
            }
        });

        //switch初始直
        if(gv.getabc().equals("T")){
            switch_Below.setChecked(true);
            Log.v("DB", "寫入資料完成：" + gv.getabc());
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            boys.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            girls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            name2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            point.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            upmood.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            switch_Below.setChecked(false);
            Log.v("DB", "寫入資料完成：" + gv.getabc());
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            boys.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            girls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            name2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            point.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            upmood.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        switch_Below.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    gv.setabc("T");
                    t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    boys.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    girls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    name2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    point.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    upmood.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                }else{
                    gv.setabc("F");
                    t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    boys.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    girls.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    name2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    point.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    upmood.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                }
            }
        });


        //返回點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉頁面
                Intent intent =new Intent(student_information_activity.this,main_activity.class);
                intent.setFlags( Intent . FLAG_ACTIVITY_CLEAR_TASK | Intent . FLAG_ACTIVITY_NEW_TASK ) ;
                startActivity(intent);
            }
        });

        //save點擊事件
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改學生資料
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        MysqlCon con = new MysqlCon();
                        con.run();
                        //學生資料
                        con.updateuser(gv.getuser(),name2.getText().toString(),id.getText().toString(),sex[0],txt_day.getText().toString());
                    }
                }).start();
                //修改學生資料
                mDBHelper.updatestudent(gv.getuser(),id.getText().toString(),name2.getText().toString(), sex[0],txt_day.getText().toString());

                Context context = getApplicationContext();
                CharSequence text = "完成儲存!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                //關閉頁面
                Intent intent =new Intent(student_information_activity.this,main_activity.class);
                intent.setFlags( Intent . FLAG_ACTIVITY_CLEAR_TASK | Intent . FLAG_ACTIVITY_NEW_TASK ) ;
                startActivity(intent);
            }
        });
    }
}