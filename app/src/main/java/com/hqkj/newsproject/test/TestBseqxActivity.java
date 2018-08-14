package com.hqkj.newsproject.test;

import android.os.Bundle;
import android.view.View;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;
import com.hqkj.newsproject.widget.MyWaveView;

public class TestBseqxActivity extends BaseActivity{
    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test_bseqx;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        MyWaveView myWaveView = findViewById(R.id.mywaveview);
        myWaveView.startWaveLine();
    }

    @Override
    public void initData() {

    }
}
