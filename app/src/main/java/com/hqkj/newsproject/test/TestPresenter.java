package com.hqkj.newsproject.test;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.hqkj.newsproject.base.BaseContract;
import com.hqkj.newsproject.base.BasePresenter;
import com.hqkj.newsproject.net.util.BaseResponse;
import com.hqkj.newsproject.net.util.BaseVcObserver;
import com.hqkj.newsproject.net.util.ExceptionHandle;
import com.hqkj.newsproject.net.util.RetrofitClient;
import com.hqkj.newsproject.net.util.RxSchedulers;
import com.hqkj.newsproject.utils.ActivityUtils;

import java.util.HashMap;
import java.util.Map;

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter{

    public Context mContext;
    public TestPresenter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void onLogin() {
        Map map = new HashMap();
        map.put("loginName","小关");
        map.put("password","123456");
        RetrofitClient.getInstance(mContext).getApiService().loginRX(map)
                .compose(RxSchedulers.<BaseResponse>applySchedulers())
                .subscribeWith(new BaseVcObserver<BaseResponse>() {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        Log.i("RetrofitTextActivity",baseResponse.getCode()+"");

                        mView.onSuccess(baseResponse.getCode());
                    }
                });
    }



}
