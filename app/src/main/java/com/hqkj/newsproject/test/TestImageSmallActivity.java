package com.hqkj.newsproject.test;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestImageSmallActivity extends BaseActivity {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.root)
    ConstraintLayout root;
    ConstraintSet constraintSet1;
    ConstraintSet constraintSet2;
    private boolean flag;
    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test_image_small;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        constraintSet1 = new ConstraintSet();
        constraintSet2 = new ConstraintSet();
        constraintSet1.clone(root);
        constraintSet2.load(this,R.layout.activity_test_image_big);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imageView)
    public void onViewClicked() {
        TransitionManager.beginDelayedTransition(root);
        flag = !flag;
        if (flag){
            constraintSet2.applyTo(root);
        }else {
            constraintSet1.applyTo(root);
        }
    }
}
