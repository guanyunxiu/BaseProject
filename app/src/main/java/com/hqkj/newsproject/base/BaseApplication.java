package com.hqkj.newsproject.base;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import com.hqkj.newsproject.config.SharedConstants;
import com.hqkj.newsproject.utils.FontsOverride;
import com.hqkj.newsproject.utils.SharedPrefUtil;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


/**
 * 内容：
 * Created by 关云秀 on 2017\8\7 0007.
 */

public class BaseApplication extends MultiDexApplication  {
    private static BaseApplication mApplication;
    public static List<Activity> activityList = new LinkedList<Activity>();
    public static SharedPrefUtil mSharedPrefUtil;
    public static int screenWidth;//屏幕宽度
    public static int screenHeight;//屏幕高度
    public static float screenDensity;//屏幕密度
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mSharedPrefUtil = new SharedPrefUtil(this, SharedConstants.sharersinfor);
      //  CrashHandler.getInstance().init(this);
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/PingFang SC Regular.ttf");

        initScreenSize();



    }


    /**
     * 初始化当前设备屏幕宽高
     */
    private void initScreenSize() {
        DisplayMetrics curMetrics = getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = curMetrics.widthPixels;
        screenHeight = curMetrics.heightPixels;
        screenDensity = curMetrics.density;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }



    public static BaseApplication getInstance() {
        return mApplication;
    }

    public void removeActivity(Activity act, int index) {
        if (activityList != null && !activityList.isEmpty()) {
            activityList.remove(act);
        }
    }

    public void addActivity(Activity act) {
        if (activityList != null) {
            activityList.add(act);
        }
    }

    public List<Activity> getActivityList() {
        return activityList;
    }


    public static void removeActivity() {
        Log.i("activityList", activityList.size() + "***");
        //
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }







}
