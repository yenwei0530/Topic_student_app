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
 * Use the {@link Fragment_statistics_thermometer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_statistics_thermometer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_statistics_thermometer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTest02Order.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_statistics_thermometer newInstance(String param1, String param2) {
        Fragment_statistics_thermometer fragment = new Fragment_statistics_thermometer();
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
        View view = inflater.inflate(R.layout.fragment2, container, false);

        //建立共用變數類別
        GlobalVariable gv = (GlobalVariable)getActivity().getApplicationContext();

        Thread thread1 = new Thread() {
            @Override
            public void run ( ) {
                MysqlCon con = new MysqlCon();
                con.run();
                arrayList=con.getthvalue(gv.getuser(),gv.getstatistics());
            };
        };
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e("OK3", String.valueOf(arrayList));

        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int f=0;
        int g=0;
        int h=0;
        int j=0;
        int k=0;


        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("tmmt_mood1").equals("1怒氣沖沖失去理智")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("2憤怒發脾氣")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("3不高興")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("4平靜")){
                d++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("5開心")){
                e++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("6興奮")){
                f++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("7非常快樂")){
                g++;
            }
        }


        //填資料
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("怒氣沖沖失去理智", a));
        data.add(new ValueDataEntry("憤怒發脾氣", b));
        data.add(new ValueDataEntry("不高興", c));
        data.add(new ValueDataEntry("平靜", d));
        data.add(new ValueDataEntry("開心", e));
        data.add(new ValueDataEntry("興奮", f));
        data.add(new ValueDataEntry("非常快樂", g));

        //建圖表
        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);

        APIlib.getInstance().setActiveAnyChartView(anyChartView);
        Pie pie = AnyChart.pie();
        pie.data(data);
        pie.title("現在的心情_"+gv.getstatistics());

        anyChartView.setChart(pie);


        a=0;
        b=0;
        c=0;
        d=0;
        e=0;
        f=0;
        g=0;



        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("tmmt_mood2").equals("怒氣沖沖失去理智")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("憤怒發脾氣")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("不高興")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("平靜")){
                d++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("開心")){
                e++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("興奮")){
                f++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("非常快樂")){
                g++;
            }
        }


        //填資料
        List<DataEntry> data6 = new ArrayList<>();
        data6.add(new ValueDataEntry("怒氣沖沖失去理智", a));
        data6.add(new ValueDataEntry("憤怒發脾氣", b));
        data6.add(new ValueDataEntry("不高興", c));
        data6.add(new ValueDataEntry("平靜", d));
        data6.add(new ValueDataEntry("開心", e));
        data6.add(new ValueDataEntry("興奮", f));
        data6.add(new ValueDataEntry("非常快樂", g));

        //建圖表
        AnyChartView anyChartView6 = view.findViewById(R.id.any_chart_view6);

        APIlib.getInstance().setActiveAnyChartView(anyChartView6);
        Pie pie6 = AnyChart.pie();
        pie6.data(data6);
        pie6.title("心情圖示_"+gv.getstatistics());

        anyChartView6.setChart(pie6);



        a=0;
        b=0;
        c=0;
        d=0;
        e=0;
        f=0;
        g=0;
        h=0;
        j=0;
        k=0;

        for (int y=0;y<=arrayList.size()-1;y++) {

            String[] array = arrayList.get(y).get("tmmt_body").split(",");

            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("呼吸變急")) {
                    a++;
                }
                if (array[i].equals("心跳變快")) {
                    b++;
                }
                if (array[i].equals("流汗增加")) {
                    c++;
                }
                if (array[i].equals("臉部變紅")) {
                    d++;
                }
                if (array[i].equals("肌肉變緊張")) {
                    e++;
                }
                if (array[i].equals("聲音變大聲或尖銳")) {
                    f++;
                }
                if (array[i].equals("流淚")) {
                    g++;
                }
                if (array[i].equals("發抖")) {
                    h++;
                }
                if (array[i].equals("想嘔吐")) {
                    j++;
                }
                if (array[i].equals("胃覺得不舒服")) {
                    k++;
                }
            }
        }

        //填資料
        List<DataEntry> data2 = new ArrayList<>();
        data2.add(new ValueDataEntry("呼吸變急", a));
        data2.add(new ValueDataEntry("心跳變快", b));
        data2.add(new ValueDataEntry("流汗增加", c));
        data2.add(new ValueDataEntry("臉部變紅", d));
        data2.add(new ValueDataEntry("肌肉變緊張", e));
        data2.add(new ValueDataEntry("聲音變大聲或尖銳", f));
        data2.add(new ValueDataEntry("流淚", g));
        data2.add(new ValueDataEntry("發抖", h));
        data2.add(new ValueDataEntry("想嘔吐", j));
        data2.add(new ValueDataEntry("胃覺得不舒服", k));

        //建圖表
        AnyChartView anyChartView2 = view.findViewById(R.id.any_chart_view2);

        APIlib.getInstance().setActiveAnyChartView(anyChartView2);
        Pie pie2 = AnyChart.pie();
        pie2.data(data2);
        pie2.title("身體反應_"+gv.getstatistics());

        anyChartView2.setChart(pie2);


        a=0;
        b=0;
        c=0;
        d=0;
        e=0;
        f=0;

        for (int y=0;y<=arrayList.size()-1;y++) {

            String[] array = arrayList.get(y).get("tmmt_idea").split(",");

            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("想打自己")) {
                    a++;
                }
                if (array[i].equals("想咬自己")) {
                    b++;
                }
                if (array[i].equals("想打他")) {
                    c++;
                }
                if (array[i].equals("想罵他")) {
                    d++;
                }
                if (array[i].equals("想撕掉作業簿")) {
                    e++;
                }
                if (array[i].equals("想把東西弄壞")) {
                    f++;
                }
            }
        }

        //填資料
        List<DataEntry> data3 = new ArrayList<>();
        data3.add(new ValueDataEntry("想打自己", a));
        data3.add(new ValueDataEntry("想咬自己", b));
        data3.add(new ValueDataEntry("想打他", c));
        data3.add(new ValueDataEntry("想罵他", d));
        data3.add(new ValueDataEntry("想撕掉作業簿", e));
        data3.add(new ValueDataEntry("想把東西弄壞", f));


        //建圖表
        AnyChartView anyChartView3 = view.findViewById(R.id.any_chart_view3);

        APIlib.getInstance().setActiveAnyChartView(anyChartView3);
        Pie pie3 = AnyChart.pie();
        pie3.data(data3);
        pie3.title("當時的想法_"+gv.getstatistics());

        anyChartView3.setChart(pie3);

       a=0;
       b=0;
       c=0;
       d=0;


        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("tmmt_calmidea").equals("提醒自己的話")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_calmidea").equals("放鬆訓練")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_calmidea").equals("想像法")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_calmidea").equals("轉移注意力")){
                d++;
            }
        }


        //填資料
        List<DataEntry> data4 = new ArrayList<>();
        data4.add(new ValueDataEntry("提醒自己的話", a));
        data4.add(new ValueDataEntry("放鬆訓練", b));
        data4.add(new ValueDataEntry("想像法", c));
        data4.add(new ValueDataEntry("轉移注意力", d));

        //建圖表
        AnyChartView anyChartView4 = view.findViewById(R.id.any_chart_view4);

        APIlib.getInstance().setActiveAnyChartView(anyChartView4);
        Pie pie4 = AnyChart.pie();
        pie4.data(data4);
        pie4.title("冷靜的分法_"+gv.getstatistics());

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
            if(arrayList.get(i).get("tmmt_mood3").equals("1怒氣沖沖失去理智")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("2憤怒發脾氣")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("3不高興")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("4平靜")){
                d++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("5開心")){
                e++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("6興奮")){
                f++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("7非常快樂")){
                g++;
            }
        }


        //填資料
        List<DataEntry> data5 = new ArrayList<>();
        data5.add(new ValueDataEntry("怒氣沖沖失去理智", a));
        data5.add(new ValueDataEntry("憤怒發脾氣", b));
        data5.add(new ValueDataEntry("不高興", c));
        data5.add(new ValueDataEntry("平靜", d));
        data5.add(new ValueDataEntry("開心", e));
        data5.add(new ValueDataEntry("興奮", f));
        data5.add(new ValueDataEntry("非常快樂", g));

        //建圖表
        AnyChartView anyChartView5 = view.findViewById(R.id.any_chart_view5);

        APIlib.getInstance().setActiveAnyChartView(anyChartView5);
        Pie pie5 = AnyChart.pie();
        pie5.data(data5);
        pie5.title("第二次現在的心情_"+gv.getstatistics());

        anyChartView5.setChart(pie5);



        // Inflate the layout for this fragment
        return view;
    }
}