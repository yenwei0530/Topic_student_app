package com.example.student;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scale2_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale2);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView t1 =findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView tt=findViewById(R.id.tt);
        TextView tt2=findViewById(R.id.tt2);

        //宣告SeekBar物件
        SeekBar seek_bar=findViewById(R.id.seek_bar);

        //宣告Button物件
        Button nextpage=findViewById(R.id.nextpage);
        Button uppage=findViewById(R.id.uppage);

        if(gv.getabc().equals("T")){
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            tt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            tt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            tt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            tt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }


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
            @Override
            public void onClick(View v) {
                //將答案存入全域變數
                gv.setscale2(t1.getText().toString().substring(0,1));


                //跳至下一頁面
                Intent intent =new Intent(scale2_activity.this, scale3_activity.class);
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