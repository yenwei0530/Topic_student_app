package com.example.student;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class student_information_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();


        //宣告Button物件
        Button exit=findViewById(R.id.exit);
        //Button save=findViewById(R.id.save);

        //宣告ImageView物件
        //ImageView img1=findViewById(R.id.img1);

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
                int data3 = Integer.parseInt(con.getprizecount(gv.getuser()));
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
        TextView t2=findViewById(R.id.t2);
        TextView t3=findViewById(R.id.t3);
        TextView t4=findViewById(R.id.t4);
        TextView t5=findViewById(R.id.t5);
        TextView t6=findViewById(R.id.t6);
        TextView t7=findViewById(R.id.t7);


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

        //switch初始直
        if(gv.getabc().equals("T")){
            switch_Below.setChecked(true);
            Log.v("DB", "寫入資料完成：" + gv.getabc());
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
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
            t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
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
                    t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
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
                    t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    id.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
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