package com.hqkj.newsproject.test;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UiTestActivity extends BaseActivity {
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.change)
    Button change;
    @BindView(R.id.apply)
    Button apply;
    ConstraintSet constraintSet1;
    ConstraintSet constraintSet2;
    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_ui_test;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        constraintSet1 = new ConstraintSet();
        constraintSet2 = new ConstraintSet();
        constraintSet1.clone(constraintLayout);
        constraintSet2.clone(constraintLayout);
    }

    @Override
    public void initData() {

    }



    @OnClick({R.id.change, R.id.apply})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change:
                TransitionManager.beginDelayedTransition(constraintLayout);
               // constraintSet2.setMargin(R.id.button2,ConstraintSet.START,30);
                //constraintSet2.constrainWidth(R.id.button2,500);

                constraintSet2.setMargin(R.id.button2,ConstraintSet.START,0);
                constraintSet2.centerHorizontally(R.id.button2,R.id.constraintLayout);
                constraintSet2.applyTo(constraintLayout);
                break;
            case R.id.apply:
                TransitionManager.beginDelayedTransition(constraintLayout);
                constraintSet1.applyTo(constraintLayout);
                break;
        }
    }
}
