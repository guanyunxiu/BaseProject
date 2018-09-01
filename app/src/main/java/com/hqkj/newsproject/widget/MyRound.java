package com.hqkj.newsproject.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.hqkj.newsproject.R;

import java.util.ArrayList;
import java.util.List;

public class MyRound extends View {
    private int ballX = 375;
    private int ballY = 375;
    private int radius = 350;
    private int width = 25;
    private int startAngle = 360;
    private int angleSpeed = 1;
    private Context mContext;
    public MyRound(Context context) {

        super(context);
        mContext = context;
    }
    public MyRound(Context context,AttributeSet attrs){
        super(context, attrs);
        mContext = context;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        CircleRing cRing = new CircleRing(ballX, ballY, radius, width, Color.RED,mContext);
        cRing.drawCircleRing(canvas, startAngle);

        /*
        if (startAngle <= 0) {
            angleSpeed = 1;
        } else if (startAngle >= 90) {
            angleSpeed = -1;
        }
        */
        startAngle += angleSpeed;
        if (startAngle == 360) {
            startAngle = 0;
        }
//        startAngle %= 360;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //invalidate();
    }


}
