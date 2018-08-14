package com.hqkj.newsproject.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.hqkj.newsproject.R;
import com.hqkj.newsproject.adapter.TestAdapter;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;
import com.hqkj.newsproject.widget.CustomLoadMoreView;

import java.security.KeyStore;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class PieChartActivity extends BaseActivity {
    PieChart mPieChart,mPieChart2;
    LinearLayout legendLayout,legendLayout2;
    RecyclerView mRecyclerView;
    View headerView;
    private int[] colors1,colors2;//颜色集合
    String[] eats = {"早餐","午餐","晚餐"};
    String[] eats2 = {"蛋白质","脂肪","碳水化合物"};
    TestAdapter testAdapter;
    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test_pie_chart;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView)findViewById(R.id.mRecyclerView) ;
        setRlv();
        addHeaderView();

    }
    public void setRlv(){
        final List beanList = new ArrayList<>();
        for(int i=0;i<10;i++){
            beanList.add("aa");
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(testAdapter = new TestAdapter(beanList));
        testAdapter.setEnableLoadMore(true);
        testAdapter.setLoadMoreView(new CustomLoadMoreView());
        testAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        testAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                final List beanList2 = new ArrayList<>();
                for(int i=0;i<10;i++){
                    beanList2.add("aa");
                }
                beanList.addAll(beanList2);
                testAdapter.setNewData(beanList);
            }
        }, mRecyclerView);
    }
    /**
     * 头部标题
     */
    private void addHeaderView() {
        headerView = this.getLayoutInflater().inflate(R.layout.activity_test_pie_chart_header, null);
        headerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        testAdapter.addHeaderView(headerView);
        mPieChart = (PieChart) headerView.findViewById(R.id.chart1);
        mPieChart2 = (PieChart)headerView.findViewById(R.id.chart2) ;
        legendLayout = (LinearLayout)headerView.findViewById(R.id.legendLayout);
        legendLayout2 = (LinearLayout)headerView.findViewById(R.id.legendLayout2) ;


        colors1 = new int[]{0xfff0914a,0xfff7cc63,0xffed707c};
        colors2 = new int[]{0xfff8685d,0xfff78cb8,0xffc8b8e6};
        //模拟数据
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry(48));
        entries.add(new PieEntry(32));
        entries.add(new PieEntry(20));
        ArrayList<PieEntry> entries2 = new ArrayList<PieEntry>();
        entries2.add(new PieEntry(58));
        entries2.add(new PieEntry(17));
        entries2.add(new PieEntry(25));
        setChart(mPieChart,colors1,entries,legendLayout,eats);
        setChart(mPieChart2,colors2,entries2,legendLayout2,eats2);
    }


    public void setChart(PieChart pieChart,int[] colors, ArrayList<PieEntry> entries,LinearLayout legendLayout,String[] eats){
        pieChart.animateX(1400);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setTransparentCircleRadius(0f);
        // 触摸旋转
        pieChart.setRotationEnabled(true);
        //设置点击Item高亮是否可用
        pieChart.setHighlightPerTapEnabled(false);


        //设置数据
        setData(entries,colors,pieChart);

        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        //设置图列
        pieChart.getLegend().setEnabled(false);
        customizeLegend(entries,colors,legendLayout,eats);
        // 输入标签样式

        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(10f);
    }
    //设置数据
    private void setData(ArrayList<PieEntry> entries,int[] colors,PieChart pieChart) {
        PieDataSet dataSet = new PieDataSet(entries,"");
       // dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        //数据和颜色

        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        DecimalFormat df = new DecimalFormat("0");
        data.setValueFormatter(new PercentFormatter(df));
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        pieChart.setData(data);
        pieChart.highlightValues(null);
        //刷新
        pieChart.invalidate();
    }

    @Override
    public void initData() {

    }
    /**
     * 定制图例，通过代码生成布局
     */
    private void customizeLegend( ArrayList<PieEntry> datas,int[] colors,LinearLayout legendLayout,String[] eats){
        for(int i=0;i<datas.size();i++){
            View view = this.getLayoutInflater().inflate(R.layout.activity_test_pie_chart_item, null);
            LinearLayout.LayoutParams lp=new LinearLayout.
                    LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            lp.weight=1;//设置比重为1
            view.setLayoutParams(lp);
            View colorView = view.findViewById(R.id.color_lv);
            TextView nameTv = view.findViewById(R.id.name);
            TextView presentTv = view.findViewById(R.id.present);
            nameTv.setText(eats[i]+"");
            DecimalFormat df = new DecimalFormat("0");
            presentTv.setText(df.format(datas.get(i).getValue())+"%");
            colorView.setBackgroundColor(colors[i]);
            legendLayout.addView(view);//legendLayout为外层布局即整个图例布局，是在xml文件中定义

        }
    }

}
