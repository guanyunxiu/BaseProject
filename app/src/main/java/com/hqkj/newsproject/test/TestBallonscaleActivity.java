package com.hqkj.newsproject.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;
import com.hqkj.newsproject.widget.MyRound;
import com.hqkj.newsproject.widget.RoundImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestBallonscaleActivity extends BaseActivity {
    @BindView(R.id.img)
    TextView img;
    @BindView(R.id.round)
    MyRound round;
    @BindView(R.id.flv)
    FrameLayout flv;

    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test_ballonscale;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        // 放大小时view，完全显示后开始呼吸效果
        setAnim();
        RoundImageView roundImageView = new RoundImageView(this);
        roundImageView.startAnimation();

    }
   public void setAnim(){
       ScaleAnimation enterAnim = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
       enterAnim.setDuration(3000); // 默认只执行一遍
       enterAnim.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {
               img.setText("吸气");
           }
           @Override
           public void onAnimationRepeat(Animation animation) { }

           @Override
           public void onAnimationEnd(Animation animation) {
               img.setText("保持");
               // 在Handler中执行子线程并延迟3s。
               mHandler .postDelayed(mRunnable, 3000);
           }
       });
       flv.startAnimation(enterAnim);
   }
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(1);
        }
    };
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//3s后执行代码
            ScaleAnimation anim = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(3000);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    img.setText("呼气");
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    setAnim();
                }
                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            flv.startAnimation(anim);
        }
    };
    @Override
    public void initData() {

    }

}
