package com.example.student;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_statistics_diary#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_statistics_diary extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_statistics_diary() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTest03Setting.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_statistics_diary newInstance(String param1, String param2) {
        Fragment_statistics_diary fragment = new Fragment_statistics_diary();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getActivity().getApplicationContext();

        Thread thread1 = new Thread() {
            @Override
            public void run ( ) {
                MysqlCon con = new MysqlCon();
                con.run();
                arrayList=con.getdiaryvalue(gv.getuser());
            };
        };
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e("OK4", String.valueOf(arrayList));

        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int f=0;
        int g=0;

        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("mood").equals("非常快樂")){
                a++;
            }
            if(arrayList.get(i).get("mood").equals("興奮")){
                b++;
            }
            if(arrayList.get(i).get("mood").equals("開心")){
                c++;
            }
            if(arrayList.get(i).get("mood").equals("良好")){
                d++;
            }
            if(arrayList.get(i).get("mood").equals("差勁")){
                e++;
            }
            if(arrayList.get(i).get("mood").equals("生氣")){
                f++;
            }
            if(arrayList.get(i).get("mood").equals("惱火")){
                g++;
            }
        }


        //填資料
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("非常快樂", a));
        data.add(new ValueDataEntry("興奮", b));
        data.add(new ValueDataEntry("開心", c));
        data.add(new ValueDataEntry("良好", d));
        data.add(new ValueDataEntry("差勁", e));
        data.add(new ValueDataEntry("生氣", f));
        data.add(new ValueDataEntry("惱火", g));

        //建圖表
        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);

        APIlib.getInstance().setActiveAnyChartView(anyChartView);
        Pie pie = AnyChart.pie();
        pie.data(data);
        pie.title("第一題");

        anyChartView.setChart(pie);

        a=0;
        b=0;
        c=0;
        d=0;

        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("weather").equals("晴天")){
                a++;
            }
            if(arrayList.get(i).get("weather").equals("陰涼")){
                b++;
            }
            if(arrayList.get(i).get("weather").equals("雨天")){
                c++;
            }
            if(arrayList.get(i).get("weather").equals("雷雨交加")){
                d++;
            }
        }


        //填資料
        List<DataEntry> data2 = new ArrayList<>();
        data2.add(new ValueDataEntry("晴天", a));
        data2.add(new ValueDataEntry("陰涼", b));
        data2.add(new ValueDataEntry("雨天", c));
        data2.add(new ValueDataEntry("雷雨交加", d));


        //建圖表
        AnyChartView anyChartView2 = view.findViewById(R.id.any_chart_view2);

        APIlib.getInstance().setActiveAnyChartView(anyChartView2);
        Pie pie2 = AnyChart.pie();
        pie2.data(data2);
        pie2.title("第二題");

        anyChartView2.setChart(pie2);

        a=0;
        b=0;
        c=0;
        d=0;

        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("person").equals("自己")){
                a++;
            }
            if(arrayList.get(i).get("person").equals("家人")){
                b++;
            }
            if(arrayList.get(i).get("person").equals("朋友")){
                c++;
            }
            if(arrayList.get(i).get("person").equals("老師")){
                d++;
            }
        }


        //填資料
        List<DataEntry> data3 = new ArrayList<>();
        data3.add(new ValueDataEntry("自己", a));
        data3.add(new ValueDataEntry("家人", b));
        data3.add(new ValueDataEntry("朋友", c));
        data3.add(new ValueDataEntry("老師", d));


        //建圖表
        AnyChartView anyChartView3 = view.findViewById(R.id.any_chart_view3);

        APIlib.getInstance().setActiveAnyChartView(anyChartView3);
        Pie pie3 = AnyChart.pie();
        pie3.data(data3);
        pie3.title("第三題");

        anyChartView3.setChart(pie3);

        a=0;
        b=0;
        c=0;
        d=0;

        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("time").equals("早上")){
                a++;
            }
            if(arrayList.get(i).get("time").equals("中午")){
                b++;
            }
            if(arrayList.get(i).get("time").equals("下午")){
                c++;
            }
            if(arrayList.get(i).get("time").equals("晚上")){
                d++;
            }
        }


        //填資料
        List<DataEntry> data4 = new ArrayList<>();
        data4.add(new ValueDataEntry("早上", a));
        data4.add(new ValueDataEntry("中午", b));
        data4.add(new ValueDataEntry("下午", c));
        data4.add(new ValueDataEntry("晚上", d));


        //建圖表
        AnyChartView anyChartView4 = view.findViewById(R.id.any_chart_view4);

        APIlib.getInstance().setActiveAnyChartView(anyChartView4);
        Pie pie4 = AnyChart.pie();
        pie4.data(data4);
        pie4.title("第四題");

        anyChartView4.setChart(pie4);

        a=0;
        b=0;
        c=0;
        d=0;
        e=0;
        f=0;
        g=0;

        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("fraction").equals("1")){
                a++;
            }
            if(arrayList.get(i).get("fraction").equals("2")){
                b++;
            }
            if(arrayList.get(i).get("fraction").equals("3")){
                c++;
            }
            if(arrayList.get(i).get("fraction").equals("4")){
                d++;
            }
            if(arrayList.get(i).get("fraction").equals("5")){
                e++;
            }
            if(arrayList.get(i).get("fraction").equals("6")){
                f++;
            }
            if(arrayList.get(i).get("fraction").equals("7")){
                g++;
            }
        }


        //填資料
        List<DataEntry> data5 = new ArrayList<>();
        data5.add(new ValueDataEntry("1", a));
        data5.add(new ValueDataEntry("2", b));
        data5.add(new ValueDataEntry("3", c));
        data5.add(new ValueDataEntry("4", d));
        data5.add(new ValueDataEntry("5", e));
        data5.add(new ValueDataEntry("6", f));
        data5.add(new ValueDataEntry("7", g));

        //建圖表
        AnyChartView anyChartView5 = view.findViewById(R.id.any_chart_view5);

        APIlib.getInstance().setActiveAnyChartView(anyChartView5);
        Pie pie5 = AnyChart.pie();
        pie5.data(data5);
        pie5.title("第五題");

        anyChartView5.setChart(pie5);

        return view;
    }
}