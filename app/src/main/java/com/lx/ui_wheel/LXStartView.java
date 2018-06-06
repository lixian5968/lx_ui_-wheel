package com.lx.ui_wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixian on 2017/4/14.
 */

public class LXStartView extends View {

    public LXStartView(Context context) {
        super(context);
    }

    public LXStartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LXStartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int width;
    int height;
    float LxR;
    List<LxPoint> mPoints;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
//        LxR = Math.min(width, height) / 2;
        LxR=100;
        mPoints = new ArrayList<>();
    }

    int count = 5;


    int type = 0;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);

        int addY =200;
        int addX=200;
        int LxR =100;
//        canvas.rotate(-90);
        Path mPath = new Path();
        mPath.moveTo(LxR+addX, 0+addY);
        for (int i = 1; i < count; i++) {
            int angle = 360 / count * i;
            mPath.lineTo(cos(angle) * LxR+addX, sin(angle) * LxR+addY);
        }
        canvas.drawPath(mPath, paint);


//        canvas.translate(-200, -200);
//        canvas.rotate(90);

    }


    /**
     * Math.sin的参数为弧度，使用起来不方便，重新封装一个根据角度求sin的方法
     *
     * @param num 角度
     * @return
     */
    float sin(int num) {
        return (float) Math.sin(num * Math.PI / 180);
    }

    /**
     * 与sin同理
     */
    float cos(int num) {
        return (float) Math.cos(num * Math.PI / 180);
    }


    public class LxPoint implements Serializable {
        public float x;
        public float y;

        public LxPoint(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }

}