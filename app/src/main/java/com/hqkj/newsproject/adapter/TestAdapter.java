package com.hqkj.newsproject.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hqkj.newsproject.R;

import java.util.List;

public class TestAdapter  extends BaseQuickAdapter<String,BaseViewHolder> {
    private int type;
    public TestAdapter(List<String> list) {
        super(R.layout.activity_test_pie_chart_rlv_item,list);
        this.type = type;
    }
    @Override
    protected void convert(BaseViewHolder helper, String str) {
        //helper.setImageResource(R.id.image,activeBean.getImage());


    }
}


