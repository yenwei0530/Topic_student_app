package com.example.student;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.RecognizerIntent;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class diary_activity5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary5);
        getSupportActionBar().hide();//關閉標題列

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button nextpage =findViewById(R.id.nextpage);
        Button uppage =findViewById(R.id.uppage);

        //宣告TextView物件
        TextView txt1=findViewById(R.id.txt1);
        TextView txt2=findViewById(R.id.txt2);
        TextView txt3=findViewById(R.id.txt3);
        TextView txt4=findViewById(R.id.txt4);


        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告ImageView物件
        ImageView imageView=findViewById(R.id.imageView);
        ImageView imageView2=findViewById(R.id.imageView2);
        ImageView imageView3=findViewById(R.id.imageView3);
        ImageView imageView8=findViewById(R.id.imageView8);

        //宣告EditText物件
        EditText edt1=findViewById(R.id.edt1);

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

        //TextView 掉落效果
        ObjectAnimator animTxtFalling = ObjectAnimator.ofFloat(txt4, "y", 0, 430);
        animTxtFalling.setDuration(3000);
        animTxtAlpha.setRepeatCount(1);
        animTxtFalling.setRepeatMode(ObjectAnimator.REVERSE);
        animTxtFalling.setInterpolator(new BounceInterpolator());
        animTxtFalling.start();


        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            edt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            edt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            nextpage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            uppage.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //ImageView點擊事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] start = {"今天在家裡，", "我喜歡", "最快樂的時候，我會", "我想知道","我最大的恐懼是","每一個媽媽","我覺得","運動","別的小孩","我沒有能"};
                int r = 0;
                r = (int)(Math.random()*9);
                edt1.setText(start[r]);

            }
        });

        //ImageView2點擊事件
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] start = {"和女生在一起時","將來的日子","我需要","我最棒的時候","使我痛苦的是","在學校裡","唯一的困難","我希望","我的爸爸"};
                int r = 0;
                r = (int)(Math.random()*8);
                edt1.setText(start[r]);
            }
        });

        //ImageView3點擊事件
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] start = {"我的媽媽","我秘密地","跳舞","多數女孩子","我想成為一個","和男生在一起時","和女生在一起時","這個測驗"};
                int r = 0;
                r = (int)(Math.random()*7);
                edt1.setText(start[r]);
            }
        });

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至主頁面
                Intent intent =new Intent(diary_activity5.this,main_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
            }
        });

        //下一頁點擊事件
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //將內容存入全域變數
                gv.setdiary5(edt1.getText().toString());

                if(edt1.getText().toString().matches("")){
                    //實體化layout
                    LayoutInflater inflater=getLayoutInflater();
                    final View textEntryView = inflater.inflate(R.layout.custom_dialog3, null);

                    //用setView把layout放進去
                    AlertDialog.Builder builder = new AlertDialog.Builder(diary_activity5.this);
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
                }else{
                    //跳至下一頁面
                    Intent intent =new Intent(diary_activity5.this, diary_activity6.class);
                    startActivity(intent);
                }
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

        //語音輸入
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "請說～");
                try{
                    startActivityForResult(intent,200);
                }catch (ActivityNotFoundException a){
                    Toast.makeText(getApplicationContext(),"Intent problem", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText edt1=findViewById(R.id.edt1);
        if(requestCode == 200){
            if(resultCode == RESULT_OK && data != null){
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                edt1.setText(result.get(0));
            }
        }
    }
}