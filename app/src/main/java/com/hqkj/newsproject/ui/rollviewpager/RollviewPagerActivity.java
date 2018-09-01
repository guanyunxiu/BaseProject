package com.hqkj.newsproject.ui.rollviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.adapter.MyPagerAdapter;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;
import com.hqkj.newsproject.bean.ViewPagerBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RollviewPagerActivity extends BaseActivity {
    @BindView(R.id.rollpager)
    RollPagerView rollpager;

    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_rollviewpager;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {
        rollpager.setHintView(new ColorPointHintView(mContext,
                getResources().getColor(R.color.colorAccent),
                Color.WHITE));
        rollpager.setAdapter(new MyPagerAdapter(getList(), mContext));
    }
    public List<ViewPagerBean> getList(){
        List list = new ArrayList();
        list.add(new ViewPagerBean("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1535788530&di=5b71d996915b0fd48aeddeb3ef21597d&src=http://pic9.photophoto.cn/20081128/0033033999061521_b.jpg"));
        list.add(new ViewPagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535798538330&di=8ba4f3037121084432104be443587fd9&imgtype=0&src=http%3A%2F%2Fpic23.photophoto.cn%2F20120503%2F0034034456597026_b.jpg"));
        list.add(new ViewPagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535798538329&di=a31d8ca5af0d8721ea7dd7c7baf46a4c&imgtype=0&src=http%3A%2F%2Fpic21.photophoto.cn%2F20111106%2F0020032891433708_b.jpg"));
        return list;
    }

}
