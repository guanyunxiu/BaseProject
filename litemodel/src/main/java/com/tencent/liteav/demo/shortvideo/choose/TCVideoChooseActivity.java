package com.tencent.liteav.demo.shortvideo.choose;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tencent.liteav.demo.R;

import java.util.ArrayList;

import static com.tencent.liteav.demo.shortvideo.choose.TCVideoChooseActivity2.TYPE_SINGLE_CHOOSE;

/**
 * Created by liyuejiao on 2018/6/14.
 */

public class TCVideoChooseActivity extends FragmentActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {

    public static final int TYPE_SINGLE_CHOOSE = 0;
    public static final int TYPE_MULTI_CHOOSE = 1;
    public static final int TYPE_PUBLISH_CHOOSE = 2;
    public static final int TYPE_MULTI_CHOOSE_PICTURE = 3;

    private TextView mVideoTv;
    private TextView mPictureTv;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mList;
    private TabFragmentPagerAdapter mAdapter;

    private HandlerThread mHandlerThread;
    private Handler mHandler;
    private int mType;
    private VideoChooseFragment mVideoChooseFragment;
    private PictureChooseFragment mPictureChooseFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_choose);
        initView();
        initData();
        requestPermission();
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.i("lyj","requestPermission");
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mVideoChooseFragment.loadVideoList();
                    mPictureChooseFragment.loadPictureList();
                }
            });
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults != null && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mVideoChooseFragment.loadVideoList();
                    mPictureChooseFragment.loadPictureList();
                }
            });
        }
    }

    private void initData() {
        mType = getIntent().getIntExtra("CHOOSE_TYPE", TYPE_SINGLE_CHOOSE);
        mVideoTv.setSelected(true);
        mViewPager.setCurrentItem(0);

        mHandlerThread = new HandlerThread("LoadList");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    private void initView() {
        mVideoTv = (TextView) findViewById(R.id.tv_item_one);
        mPictureTv = (TextView) findViewById(R.id.tv_item_two);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mVideoTv.setOnClickListener(this);
        mPictureTv.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new MyPagerChangeListener());

        mList = new ArrayList<>();
        mVideoChooseFragment = new VideoChooseFragment();
        mPictureChooseFragment = new PictureChooseFragment();
        mList.add(mVideoChooseFragment);
        mList.add(mPictureChooseFragment);
        mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), mList);
        mViewPager.setAdapter(mAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_item_one:
                mVideoTv.setSelected(true);
                mPictureTv.setSelected(false);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.tv_item_two:
                mVideoTv.setSelected(false);
                mPictureTv.setSelected(true);
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    private class MyPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mVideoTv.setSelected(true);
                    mPictureTv.setSelected(false);
                    break;
                case 1:
                    mVideoTv.setSelected(false);
                    mPictureTv.setSelected(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
