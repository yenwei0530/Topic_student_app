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
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//??????????????????

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        //????????????????????????
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
            if(arrayList.get(i).get("tmmt_mood1").equals("1????????????????????????")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("2???????????????")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("3?????????")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("4??????")){
                d++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("5??????")){
                e++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("6??????")){
                f++;
            }
            if(arrayList.get(i).get("tmmt_mood1").equals("7????????????")){
                g++;
            }
        }


        //?????????
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("????????????????????????", a));
        data.add(new ValueDataEntry("???????????????", b));
        data.add(new ValueDataEntry("?????????", c));
        data.add(new ValueDataEntry("??????", d));
        data.add(new ValueDataEntry("??????", e));
        data.add(new ValueDataEntry("??????", f));
        data.add(new ValueDataEntry("????????????", g));

        //?????????
        AnyChartView anyChartView = view.findViewById(R.id.any_chart_view);

        APIlib.getInstance().setActiveAnyChartView(anyChartView);
        Pie pie = AnyChart.pie();
        pie.data(data);
        pie.title("???????????????_"+gv.getstatistics());

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
            if(arrayList.get(i).get("tmmt_mood2").equals("????????????????????????")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("???????????????")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("?????????")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("??????")){
                d++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("??????")){
                e++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("??????")){
                f++;
            }
            if(arrayList.get(i).get("tmmt_mood2").equals("????????????")){
                g++;
            }
        }


        //?????????
        List<DataEntry> data6 = new ArrayList<>();
        data6.add(new ValueDataEntry("????????????????????????", a));
        data6.add(new ValueDataEntry("???????????????", b));
        data6.add(new ValueDataEntry("?????????", c));
        data6.add(new ValueDataEntry("??????", d));
        data6.add(new ValueDataEntry("??????", e));
        data6.add(new ValueDataEntry("??????", f));
        data6.add(new ValueDataEntry("????????????", g));

        //?????????
        AnyChartView anyChartView6 = view.findViewById(R.id.any_chart_view6);

        APIlib.getInstance().setActiveAnyChartView(anyChartView6);
        Pie pie6 = AnyChart.pie();
        pie6.data(data6);
        pie6.title("????????????_"+gv.getstatistics());

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
                if (array[i].equals("????????????")) {
                    a++;
                }
                if (array[i].equals("????????????")) {
                    b++;
                }
                if (array[i].equals("????????????")) {
                    c++;
                }
                if (array[i].equals("????????????")) {
                    d++;
                }
                if (array[i].equals("???????????????")) {
                    e++;
                }
                if (array[i].equals("????????????????????????")) {
                    f++;
                }
                if (array[i].equals("??????")) {
                    g++;
                }
                if (array[i].equals("??????")) {
                    h++;
                }
                if (array[i].equals("?????????")) {
                    j++;
                }
                if (array[i].equals("??????????????????")) {
                    k++;
                }
            }
        }

        //?????????
        List<DataEntry> data2 = new ArrayList<>();
        data2.add(new ValueDataEntry("????????????", a));
        data2.add(new ValueDataEntry("????????????", b));
        data2.add(new ValueDataEntry("????????????", c));
        data2.add(new ValueDataEntry("????????????", d));
        data2.add(new ValueDataEntry("???????????????", e));
        data2.add(new ValueDataEntry("????????????????????????", f));
        data2.add(new ValueDataEntry("??????", g));
        data2.add(new ValueDataEntry("??????", h));
        data2.add(new ValueDataEntry("?????????", j));
        data2.add(new ValueDataEntry("??????????????????", k));

        //?????????
        AnyChartView anyChartView2 = view.findViewById(R.id.any_chart_view2);

        APIlib.getInstance().setActiveAnyChartView(anyChartView2);
        Pie pie2 = AnyChart.pie();
        pie2.data(data2);
        pie2.title("????????????_"+gv.getstatistics());

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
                if (array[i].equals("????????????")) {
                    a++;
                }
                if (array[i].equals("????????????")) {
                    b++;
                }
                if (array[i].equals("?????????")) {
                    c++;
                }
                if (array[i].equals("?????????")) {
                    d++;
                }
                if (array[i].equals("??????????????????")) {
                    e++;
                }
                if (array[i].equals("??????????????????")) {
                    f++;
                }
            }
        }

        //?????????
        List<DataEntry> data3 = new ArrayList<>();
        data3.add(new ValueDataEntry("????????????", a));
        data3.add(new ValueDataEntry("????????????", b));
        data3.add(new ValueDataEntry("?????????", c));
        data3.add(new ValueDataEntry("?????????", d));
        data3.add(new ValueDataEntry("??????????????????", e));
        data3.add(new ValueDataEntry("??????????????????", f));


        //?????????
        AnyChartView anyChartView3 = view.findViewById(R.id.any_chart_view3);

        APIlib.getInstance().setActiveAnyChartView(anyChartView3);
        Pie pie3 = AnyChart.pie();
        pie3.data(data3);
        pie3.title("???????????????_"+gv.getstatistics());

        anyChartView3.setChart(pie3);

       a=0;
       b=0;
       c=0;
       d=0;


        for (int i=0;i<=arrayList.size()-1;i++)
        {
            if(arrayList.get(i).get("tmmt_calmidea").equals("??????????????????")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_calmidea").equals("????????????")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_calmidea").equals("?????????")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_calmidea").equals("???????????????")){
                d++;
            }
        }


        //?????????
        List<DataEntry> data4 = new ArrayList<>();
        data4.add(new ValueDataEntry("??????????????????", a));
        data4.add(new ValueDataEntry("????????????", b));
        data4.add(new ValueDataEntry("?????????", c));
        data4.add(new ValueDataEntry("???????????????", d));

        //?????????
        AnyChartView anyChartView4 = view.findViewById(R.id.any_chart_view4);

        APIlib.getInstance().setActiveAnyChartView(anyChartView4);
        Pie pie4 = AnyChart.pie();
        pie4.data(data4);
        pie4.title("???????????????_"+gv.getstatistics());

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
            if(arrayList.get(i).get("tmmt_mood3").equals("1????????????????????????")){
                a++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("2???????????????")){
                b++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("3?????????")){
                c++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("4??????")){
                d++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("5??????")){
                e++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("6??????")){
                f++;
            }
            if(arrayList.get(i).get("tmmt_mood3").equals("7????????????")){
                g++;
            }
        }


        //?????????
        List<DataEntry> data5 = new ArrayList<>();
        data5.add(new ValueDataEntry("????????????????????????", a));
        data5.add(new ValueDataEntry("???????????????", b));
        data5.add(new ValueDataEntry("?????????", c));
        data5.add(new ValueDataEntry("??????", d));
        data5.add(new ValueDataEntry("??????", e));
        data5.add(new ValueDataEntry("??????", f));
        data5.add(new ValueDataEntry("????????????", g));

        //?????????
        AnyChartView anyChartView5 = view.findViewById(R.id.any_chart_view5);

        APIlib.getInstance().setActiveAnyChartView(anyChartView5);
        Pie pie5 = AnyChart.pie();
        pie5.data(data5);
        pie5.title("????????????????????????_"+gv.getstatistics());

        anyChartView5.setChart(pie5);



        // Inflate the layout for this fragment
        return view;
    }
}