package com.hqkj.newsproject.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hqkj.newsproject.R;
import com.hqkj.newsproject.bean.User;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Administrator
 */
public class SchedulerTestActivity extends AppCompatActivity {
    TextView textView;
    public String TAG = "SchedulerTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler_test);
        textView = findViewById(R.id.textview);
    }

    public void click(View view) {
        Observable.create(new ObservableOnSubscribe<User>() {//被观察者发现了变化
            @Override
            public void subscribe(ObservableEmitter<User> e) throws Exception {
                   User user = new User("aa","a","xiaoguan");
                   e.onNext(user);
            }
        }).subscribeOn(Schedulers.io())//开启线程池，让网络请求在线程中执行
          .observeOn(AndroidSchedulers.mainThread())//让观察者在切换到主线程中执行
          .subscribe(new Observer<User>() {//观察者也变化
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User user) {
                Log.d(TAG,user.getUser_name());
                textView.setText(user.getUser_name());
            }

            @Override
            public void onError(Throwable e) {
               e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
