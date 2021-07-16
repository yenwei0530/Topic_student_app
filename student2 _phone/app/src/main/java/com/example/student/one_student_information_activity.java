package com.example.student;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class one_student_information_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_student_information);
        getSupportActionBar().hide();//關閉標題列
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();


        //宣告Button物件
        Button exit=findViewById(R.id.exit);
        //Button save=findViewById(R.id.save);

        //宣告ImageView物件
        ImageView img1=findViewById(R.id.img1);

        //宣告TextView物件
        TextView txt_day=findViewById(R.id.txt_day);

        //宣告EditText物件
        EditText name=findViewById(R.id.name);
        EditText id=findViewById(R.id.id);

        //宣告RadioGroup物件
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        final String[] sex = {"男"};



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
                new DatePickerDialog(one_student_information_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
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
                if(name.getText().toString().matches("")  || id.getText().toString().matches("") || txt_day.getText().toString().matches("") ){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog5, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(one_student_information_activity.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alert.cancel();
                        }
                    });
                    alert.show();
                }else {
                    //修改學生資料
                    new Thread(new Runnable(){
                        @Override
                        public void run(){
                            MysqlCon con = new MysqlCon();
                            con.run();
                            //學生資料
                            con.updateuser(gv.getuser(),name.getText().toString(),id.getText().toString(),sex[0],txt_day.getText().toString());
                        }
                    }).start();
                    //修改學生資料
                    mDBHelper.updatestudent(gv.getuser(),id.getText().toString(),name.getText().toString(), sex[0],txt_day.getText().toString());
                    //跳至下一頁面
                    Intent intent = new Intent(one_student_information_activity.this, scale0_activity.class);
                    startActivity(intent);
                }
            }
        });


    }
}