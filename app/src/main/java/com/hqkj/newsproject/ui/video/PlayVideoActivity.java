package com.hqkj.newsproject.ui.video;

import android.os.Bundle;
import android.view.View;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.base.BaseContract;
import com.superplayer.library.SuperPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayVideoActivity extends BaseActivity implements SuperPlayer.OnNetChangeListener{
    @BindView(R.id.id_super_player)
    SuperPlayer idSuperPlayer;


    @Override
    protected BaseContract.BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRetry() {

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_play_video;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {
        playVideo();
    }

    /**
     * 播放视频
     */
    public void playVideo() {
        idSuperPlayer.setVisibility(View.VISIBLE);

        idSuperPlayer.setFullScreenOnly(true);
        idSuperPlayer.setNetChangeListener(true)//设置监听手机网络的变化
                .setOnNetChangeListener(this)//实现网络变化的回调
                .onPrepared(new SuperPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared() {
                        /**
                         * 监听视频是否已经准备完成开始播放。（可以在这里处理视频封面的显示跟隐藏）
                         */
                    }
                }).onComplete(new Runnable() {
            @Override
            public void run() {
                /**
                 * 监听视频是否已经播放完成了。（可以在这里处理视频播放完成进行的操作）
                 */
                playVideo();
            }
        }).setTitle("")//设置视频的titleName
                .play("http://124.166.230.43:40001/06.mp4");//开始播放视频
        // idSuperPlayer.setScaleType(SuperPlayer.SCALETYPE_16_9);
        //idSuperPlayer.setPlayerWH(idSuperPlayer.getWidth(), idSuperPlayer.getHeight());//设置竖屏的时候屏幕的高度，如果不设置会切换后按照16:9的高度重置



    }
    /**
     * 下面的这几个Activity的生命状态很重要
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (idSuperPlayer != null) {
            idSuperPlayer.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (idSuperPlayer != null) {
            idSuperPlayer.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (idSuperPlayer != null) {
            idSuperPlayer.onDestroy();
        }
    }


    @Override
    public void onWifi() {

    }

    @Override
    public void onMobile() {

    }

    @Override
    public void onDisConnect() {

    }

    @Override
    public void onNoAvailable() {

    }
}
