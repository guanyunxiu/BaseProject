package com.hqkj.newsproject.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hqkj.newsproject.R;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {
    public String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Observable observable = getObservable();
        //Observer observer = getObserver();
       // observable.subscribe(observer);
        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(String o) throws Exception {//相当于next
                Log.d(TAG,o);
            }
        });
    }
    public Observable<String> getObservable(){
        Observable observable = Observable.just("唱歌","跳舞","聊没");
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "大保键";
            }
        });
        //return observable;
      /*  return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("aa");
                e.onNext("bb");
                e.onComplete();
            }
        });*/
    }
    public Observer<String> getObserver(){

        return new Observer<String>(){
            Disposable dd;
            @Override
            public void onSubscribe(Disposable d) {
                dd = d;
                Log.d(TAG,"onSubscribe");
            }

            @Override
            public void onNext(String s) {
                if(s.equals("泡妞")){
                    dd.dispose();
                }
                Log.d(TAG,"onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"Throwable");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"onComplete");
            }
        };
    }
}
