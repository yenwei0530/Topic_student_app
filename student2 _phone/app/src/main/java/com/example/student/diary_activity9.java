package com.example.student;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
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

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView txt1=findViewById(R.id.txt1);
        TextView txt2=findViewById(R.id.txt2);
        TextView txt3=findViewById(R.id.txt3);
        TextView txt4=findViewById(R.id.txt4);

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告TextView物件
        TextView t1 =findViewById(R.id.t1);
        TextView t2 =findViewById(R.id.t2);
        TextView t3 =findViewById(R.id.t3);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告ImageView物件
        ImageView imageView=findViewById(R.id.imageView);
        ImageView imageView2=findViewById(R.id.imageView2);
        ImageView imageView3=findViewById(R.id.imageView3);


        //TextView 旋轉效果
        ObjectAnimator animTxtRotate = ObjectAnimator.ofFloat(txt3, "rotation", 0, 360);
        animTxtRotate.setDuration(3000);
        animTxtRotate.setRepeatCount(1);
        animTxtRotate.setRepeatMode(ObjectAnimator.REVERSE);
        animTxtRotate.setInterpolator(new AccelerateDecelerateInterpolator());
        animTxtRotate.start();

        //TextView 透明度變換效果
        ObjectAnimator animTxtAlpha = ObjectAnimator.ofFloat(txt2, "alpha", 1, 0);
        animTxtAlpha.setDuration(3000);
        animTxtAlpha.setRepeatCount(1);
        animTxtAlpha.setRepeatMode(ObjectAnimator.REVERSE);
        animTxtAlpha.setInterpolator(new LinearInterpolator());
        animTxtAlpha.start();

        //TextView 放大效果
        ValueAnimator animTxtScale = ValueAnimator.ofInt(0, 50);
        animTxtScale.setDuration(500);
        animTxtScale.setRepeatCount(1);
        animTxtScale.setRepeatMode(ObjectAnimator.REVERSE);
        animTxtScale.setInterpolator(new LinearInterpolator());
        animTxtScale.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int val = (Integer) animation.getAnimatedValue();
                txt4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15 + val);
            }
        });
        animTxtScale.start();


        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }
        //語音
        MediaPlayer mp = MediaPlayer.create(this, R.raw.diary9);
        mp.start();

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
                mp.pause();
            }
        });

        //下一頁點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //將開始時間存入全域變數
                gv.setdiary9_start(t1.getText().toString());
                //將結束時間存入全域變數
                gv.setdiary9_end(t3.getText().toString());
                if(t1.getText().toString().matches("開始時間") || t3.getText().toString().matches("結束時間")){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog3, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(diary_activity9.this);
                    builder.setView(textEntryView);

                    //創建一個Dialog
                    AlertDialog alert = builder.create();

                    //layout中Button結束事件
                    TextView t1=(TextView) textEntryView.findViewById(R.id.t1);
                    TextView t2=(TextView) textEntryView.findViewById(R.id.t2);
                    Button finsh = (Button) textEntryView.findViewById(R.id.finsh);

                    if(gv.getabc().equals("T")){
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                    }else {
                        t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                        finsh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                    }
                    finsh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alert.cancel();
                        }
                    });
                    alert.show();
                }else {
                    //跳至下一頁面
                    Intent intent = new Intent(diary_activity9.this, diary_activity10.class);
                    startActivity(intent);
                    mp.pause();
                    mp.release();
                    finish();

                }
            }
        });

        //上一頁點擊事件
        uppage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉目前頁面
                Intent intent = new Intent(diary_activity9.this, diary_activity8.class);
                startActivity(intent);
                mp.pause();
                mp.release();
                finish();

            }
        });

    }
}