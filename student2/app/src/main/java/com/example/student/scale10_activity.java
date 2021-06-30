package com.example.student;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class scale10_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "student";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale10);
        getSupportActionBar().hide();//關閉標題列
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView t1 =findViewById(R.id.t1);

        //宣告SeekBar物件
        SeekBar seek_bar=findViewById(R.id.seek_bar);

        //宣告Button物件
        Button nextpage=findViewById(R.id.nextpage);
        Button uppage=findViewById(R.id.uppage);


        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==1){
                    t1.setText(progress+"從不這樣");
                }
                if(progress==2){
                    t1.setText(progress+"很少這樣");
                }
                if(progress==3){
                    t1.setText(progress+"有時這樣");
                }
                if(progress==4){
                    t1.setText(progress+"經常這樣");
                }
                if(progress==5){
                    t1.setText(progress+"總是這樣");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        nextpage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //將答案存入全域變數
                gv.setscale10(t1.getText().toString());


                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        MysqlCon con = new MysqlCon();
                        con.insertscale(gv.getuser(),gv.getscale1(),gv.getscale2(),gv.getscale3(),gv.getscale4(),gv.getscale5(),gv.getscale6(),gv.getscale7(),gv.getscale8(),gv.getscale9(),gv.getscale10());
                    }
                }).start();

                //定義好時間字串的格式
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //系統時間
                String date = sdf.format(new java.util.Date());
                //修改社會適應量表時間
                mDBHelper.updatescale(gv.getuser(),date);

                //跳至下一頁面
                Intent intent =new Intent(scale10_activity.this, main_activity.class);
                startActivity(intent);
            }
        });

        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}