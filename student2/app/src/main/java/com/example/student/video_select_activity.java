package com.example.student;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class video_select_activity extends AppCompatActivity {

    private final String DB_NAME = "treatment.db";
    private String TABLE_NAME = "video";
    private final int DB_VERSION = 1;
    SQLiteDataBaseHelper mDBHelper;
    ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();//取得所有資料
    ArrayList<String> arrayList = new ArrayList<>();//取得所有資料
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    MysqlCon con = new MysqlCon();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_select);
        getSupportActionBar().hide();//關閉標題列


        //宣告Button物件
        ImageButton exit =findViewById(R.id.exit);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getApplicationContext();

        //宣告TextView物件
        TextView txt1 =findViewById(R.id.txt1);


        //填資料
        mDBHelper = new SQLiteDataBaseHelper(this, DB_NAME, null, DB_VERSION, TABLE_NAME);//初始化資料庫
        arrayList1 = mDBHelper.video(gv.getuser());
        for (int i=0;i<=arrayList1.size()-1;i++)
        {
            arrayList.add(arrayList1.get(i).get("video"));
        }

        Log.v("OK", String.valueOf(arrayList));

        //設置RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        //設置RecyclerView滑動事件
        recyclerViewAction(recyclerView, arrayList, myAdapter);

        if(gv.getabc().equals("T")){
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));

        }else {
            txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
        }

        //離開點擊事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        class ViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            View mView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                //建立共用變數類別
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
                textView = itemView.findViewById(R.id.textView_item);
                mView  = itemView;
                if(gv.getabc().equals("T")){
                    textView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/kai08mz.TTC"));
                }else {
                    textView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ZCOOLKuaiLe-Regular.ttf"));
                }
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //點擊事件
            holder.textView.setText(arrayList.get(position));
            holder.mView.setOnClickListener((v)->{
                /*Toast.makeText(getBaseContext(),arrayList1.get(position).get("video_url"),Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(arrayList1.get(position).get("video_url")));
                startActivity(intent);
            });

        }

        @Override
        public int getItemCount() {
            //回傳幾個數列
            return arrayList.size();
        }
    }

    private void recyclerViewAction(RecyclerView recyclerView, final ArrayList<String> choose, final MyAdapter myAdapter) {

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN
                        , ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);//這裡是告訴RecyclerView你想開啟哪些操作
            }

            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                //管理上下拖曳
                int position_dragged = viewHolder.getAdapterPosition();
                int position_target = target.getAdapterPosition();
                Collections.swap(choose, position_dragged, position_target);
                myAdapter.notifyItemMoved(position_dragged, position_target);
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                //管理滑動情形
                int position = viewHolder.getAdapterPosition();
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                    case ItemTouchHelper.RIGHT:
                        //刪除資料
                        new Thread(new Runnable(){
                            @Override
                            public void run(){
                                con.run();
                                con.deletvideoid(arrayList1.get(position).get("video_id"));
                            }
                        }).start();
                        mDBHelper.deletevideoid(arrayList1.get(position).get("video_id"));
                        /*String sql = "DELETE FROM `video` WHERE `video_id` = '" +  arrayList1.get(position).get("video_id") + "'";
                        Log.v("DB", "刪除資料完成：" + sql);*/
                        //延遲一秒
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            return;
                        }
                        choose.remove(position);
                        arrayList1.remove(position);
                        myAdapter.notifyItemRemoved(position);
                        if (arrayList1.size() == 0) {
                            //跳至主頁頁面
                            Intent intent =new Intent(video_select_activity.this,main_activity.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder(c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
                        .addBackgroundColor(ContextCompat.getColor(video_select_activity.this,android.R.color.holo_red_dark))
                        .addActionIcon(R.drawable.ic_baseline_delete_24)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });
        helper.attachToRecyclerView(recyclerView);

    }


}