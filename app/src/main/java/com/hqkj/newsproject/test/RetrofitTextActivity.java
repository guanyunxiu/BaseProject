package com.hqkj.newsproject.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.base.BaseActivity;
import com.hqkj.newsproject.net.API;
import com.hqkj.newsproject.net.util.BaseVcObserver;
import com.hqkj.newsproject.net.util.RetrofitClient;
import com.hqkj.newsproject.net.util.RxSchedulers;

import java.util.HashMap;
import java.util.Map;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTextActivity extends BaseActivity<TestPresenter> implements TestContract.View {
    API api;
  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://jcy.sxsxjyjs.com:8061")
                .build();
        api = retrofit.create(API.class);
    }*/

    public void retrofit_net(View view) {
        mPresenter.onLogin();
       /* Map map = new HashMap();
        map.put("loginName","小关");
        map.put("password","123456");
        RetrofitClient.getInstance(this).getApiService().loginRX(map)
                .compose(RxSchedulers.<BaseResponse>applySchedulers())
                .subscribeWith(new BaseVcObserver<BaseResponse>() {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        Log.i("RetrofitTextActivity",baseResponse.getCode()+"");
                        Toast.makeText(RetrofitTextActivity.this,baseResponse.getCode()+"",Toast.LENGTH_SHORT).show();
                    }
                });*/
              /*  .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse userModel) {
                        Log.i("RetrofitTextActivity",userModel.getCode()+"");
                        Toast.makeText(RetrofitTextActivity.this,userModel.getCode()+"",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

     /*   Map map = new HashMap();
        map.put("loginName","小关");
        map.put("password","123456");
        api.loginRX(map)
                .subscribeOn(Schedulers.io())//网络请求在子线程中
                .flatMap(new Function<BaseResponse, Observable<UserModel>>() {
            @Override
            public Observable<UserModel> apply(BaseResponse baseResponse) throws Exception {
                Log.i("RetrofitTextActivity",baseResponse.getCode()+"");
                String s = new Gson().toJson(baseResponse.getData());
                UserModel user = new Gson().fromJson(s, new TypeToken<UserModel>() {
                }.getType());
                return Observable.just(user);
            }
        })
         .observeOn(AndroidSchedulers.mainThread())//将结果回调到Main线程
          .subscribe(new Observer<UserModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(UserModel userModel) {
                Log.i("RetrofitTextActivity",userModel.getLoginName()+"");
                Toast.makeText(RetrofitTextActivity.this,userModel.getLoginName()+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
               e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });*/
       /* api.loginRX(map)
                .subscribeOn(Schedulers.io())//在安卓中这个必须添加否则会报`NetworkOnMainThreadException`
                .observeOn(AndroidSchedulers.mainThread())//将结果回调到Main线程
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        Log.i("RetrofitTextActivity",baseResponse.getCode()+"");
                        Toast.makeText(RetrofitTextActivity.this,baseResponse.getCode()+"",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                       e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

       /* api.login(map).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                BaseResponse baseResponse =  response.body();
                Log.i("RetrofitTextActivity",baseResponse.getCode()+"");
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });*/
    }

    @Override
    public void onRetry() {
        initData();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_test_retrofit;
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {
       // showLoading();
        mPresenter.onLogin();
    }

    @Override
    public void onSuccess(int id) {
        showFaild();
        Toast.makeText(this,id+"",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected TestPresenter onCreatePresenter() {
        return  new TestPresenter(this);
    }
}
