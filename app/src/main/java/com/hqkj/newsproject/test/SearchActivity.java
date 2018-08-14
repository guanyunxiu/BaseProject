package com.hqkj.newsproject.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.bean.User;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
    EditText searchEt;
    Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_search);
        searchEt = findViewById(R.id.search_edit);
        btn = findViewById(R.id.btn_id);
        btn2 = findViewById(R.id.btn_id2);
        RxTextView.textChanges(this.searchEt)
                .debounce(200, TimeUnit.MILLISECONDS)//防抖动
                .subscribeOn(AndroidSchedulers.mainThread())//在主线程中运行
                .filter(new Func1<CharSequence, Boolean>() {//过滤字符串
                    @Override
                    public Boolean call(CharSequence charSequence) {
                        return charSequence.toString().length()>0;
                    }
                })
                .switchMap(new Func1<CharSequence, Observable<List<String>>>() {
                    @Override
                    public Observable<List<String>> call(CharSequence charSequence) {
                        //网络请求search
                        List<String> list = new ArrayList();
                        list.add("aa");
                        list.add("ab");
                        return Observable.just(list);
                    }
                })
                .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<String>>() {
                     @Override
                    public void call(List<String> strings) {
                        Log.i("SearchActivity", strings.size() + "");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("SearchActivity", throwable.toString() + "");
                    }
                });

          //重复点击测试
        RxView.clicks(btn).throttleFirst(1,TimeUnit.SECONDS).subscribe(new Observer<Void>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Void aVoid) {
              Log.i("SearchActivity","点击了");
                merge();
             }
             });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEms();
            }
        });
    }
     public void merge(){
           Observable.merge(getLocalData(),geNetData())
                   .subscribe(new Subscriber<List<User>>() {
                       @Override
                       public void onCompleted() {

                       }
                       @Override
                       public void onError(Throwable e) {
                            e.printStackTrace();
                       }

                       @Override
                       public void onNext(List<User> users) {
                        for(User user:users){
                            Log.i("SearchActivity",user.getUser_name());
                        }
                       }
                   });
     }
     public Observable<List<User>> getLocalData(){
        List<User> list = new ArrayList();
        list.add(new User("aa","a","aaaa"));
         list.add(new User("bb","b","bbbb"));
        return Observable.just(list);
     }
    public Observable<List<User>> geNetData(){
        List<User> list = new ArrayList();
        list.add(new User("ac","a","abcd"));
        list.add(new User("be","e","bdss"));
        return Observable.just(list);
    }


    /**
     * 发送验证码
     */
    public void sendEms(){

        final int count = 10;
        Observable.interval(0,1,TimeUnit.SECONDS)
                .take(count+1)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return count-aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        btn2.setEnabled(false);
                    }
                }).subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        btn2.setEnabled(true);
                        btn2.setText("发送验证码");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        btn2.setText(aLong+"");
                    }
        });
    }
}
