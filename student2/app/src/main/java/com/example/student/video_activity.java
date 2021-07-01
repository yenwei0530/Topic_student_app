package com.example.student;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class video_activity extends AppCompatActivity {
    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "video";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        getSupportActionBar().hide();//關閉標題列

        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫


        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告Button物件
        Button up =findViewById(R.id.up);
        Button exit2 =findViewById(R.id.exit2);

        //宣告EditText物件
        EditText edt1 =findViewById(R.id.edt1);

        //宣告TextView物件
        TextView txt1 =findViewById(R.id.txt1);
        TextView txt2 =findViewById(R.id.txt2);

        //宣告ImageButton物件
        ImageButton exit =findViewById(R.id.exit);

        //宣告ImageView物件
        ImageView imageView1=findViewById(R.id.imageView);
        ImageView imageView2=findViewById(R.id.imageView2);

        //宣告web_view物件
        WebView web_view = (WebView) findViewById(R.id.web_view);
        web_view.getSettings().setJavaScriptEnabled(true);

        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            edt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            up.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
            exit2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            edt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            up.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
            exit2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //宣告剪貼簿物件
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        //edt1點擊自動貼上連結事件
        edt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clipboard.hasPrimaryClip() && clipboard.getPrimaryClip().getItemCount() > 0) {
                    ClipData abc = clipboard.getPrimaryClip();
                    ClipData.Item item = abc.getItemAt(0);
                    String text = item.getText().toString();
                    edt1.setText(text);
                    web_view.loadUrl(text);
                }
            }
        });

        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                txt2.setText(view.getTitle());
            }
        });


        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        //離開點擊事件
        exit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //上傳點擊事件
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //寫入資料
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        MysqlCon con = new MysqlCon();
                        con.insertvideo(gv.getuser(),txt2.getText().toString(),edt1.getText().toString());
                        mDBHelper.addvideo(con.getvideomax(),gv.getuser(),txt2.getText().toString(),edt1.getText().toString());
                    }
                }).start();

                Context context = getApplicationContext();
                CharSequence text = "上傳完成!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                finish();
            }
        });

        //google點擊事件
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至google
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });

        //youtube點擊事件
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳至youtube
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/"));
                startActivity(intent);
            }
        });


    }
}