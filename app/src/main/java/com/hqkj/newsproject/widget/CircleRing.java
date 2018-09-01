package com.hqkj.newsproject.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.WindowManager;

public  class CircleRing {
    int ringX;
    int ringY;
    int ringRadius;
    int ringWidth;
    Paint paint;
    Context mContext;
    //    public CircleRing(int ringX, int ringY, int ringRadius, int ringWidth, int ringColor, int startAngle) {
    public CircleRing(int ringX, int ringY, int ringRadius, int ringWidth, int ringColor,Context mContext) {
        this.ringX = ringX;
        this.ringY =  ringY;
        this.ringRadius =  ringRadius;
        this.ringWidth=  ringWidth;
        this.mContext = mContext;
        paint = new Paint();
        paint.reset();
        paint.setColor(ringColor);
        paint.setAntiAlias(true); //消除锯齿
        paint.setStrokeWidth(ringWidth);
        paint.setStyle(Paint.Style.STROKE);  //绘制空心圆或 空心矩形,只显示边缘的线，不显示内部
    }

    public void drawCircleRing(Canvas canvas, int startAngle) {
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int h = windowManager.getDefaultDisplay().getHeight();
        int w = windowManager.getDefaultDisplay().getWidth();
        RectF rect = new RectF(ringX - ringRadius, ringY  - ringRadius, ringX + ringRadius, ringY + ringRadius);
        //false 不画圆心
       // paint.setAlpha(255);

        paint.setColor(0xFF2C7AE4);
        canvas.drawArc(rect, startAngle + 0, 45, false, paint);
        paint.setColor(0xFF7C7D9B);
        canvas.drawArc(rect, startAngle + 45, 90, false, paint);
        paint.setColor(0xFF945CEA);
        canvas.drawArc(rect, startAngle + 135, 135, false, paint);
        paint.setColor(0xFF2C7AE4);
        canvas.drawArc(rect, startAngle + 270, 90, false, paint);
    }

}
