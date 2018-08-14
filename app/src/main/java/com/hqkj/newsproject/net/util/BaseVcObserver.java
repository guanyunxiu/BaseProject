package com.hqkj.newsproject.net.util;

import android.app.Activity;

import android.util.Log;
import com.hqkj.newsproject.utils.ActivityUtils;

import io.reactivex.observers.ResourceObserver;

/**
 * @author quchao
 * @date 2017/11/27
 *观察者base
 * @param <T>
 */

public abstract class BaseVcObserver<T> extends ResourceObserver<T> {

    /**
     *  执行开始（可选）
     *  它会在subscribe(订阅)刚开始，而事件还未发送之前被调用，可以用于做一些准备工作
     *  它总是在subscribe(订阅)所发生的线程被调用(不合适在主线程加载进度条)
     */
    @Override
    protected void onStart() {
        super.onStart();
        Activity currentActivity = ActivityUtils.getInstance().currentActivity();
        if (!NetworkUtil.isNetworkAvailable(currentActivity)) {
            // Toast.makeText(context, "无网络，读取缓存数据", Toast.LENGTH_SHORT).show();
            onComplete();
        }
    }

    /**
     * 执行结果
     */
    @Override
    public void onComplete() {

    }

    /**
     * 执行错误
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        Log.e("Tamic", e.getMessage());
        // todo error somthing
        if(e instanceof ExceptionHandle.ResponeThrowable){
            onError((ExceptionHandle.ResponeThrowable)e);
        } else {
            onError(new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
        }
    }
    public abstract void onError(ExceptionHandle.ResponeThrowable e);
}
