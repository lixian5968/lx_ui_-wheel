package com.lx.ui_wheel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class LxView extends View {
    public LxView(Context context) {
        super(context);
        init(context, null);
    }

    public LxView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LxView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    Bitmap mBitmap;
    private void init(Context context, AttributeSet attrs) {
        BitmapDrawable mBitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(R.mipmap.tr);
        mBitmap = mBitmapDrawable.getBitmap();
        Log.e("","");
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        Paint paint = new Paint();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);

        paint.setColor(getContext().getResources().getColor(R.color.shadow));
        canvas.drawRect(0, 0, canvasWidth, canvasHeight, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        canvas.drawCircle(500, 500, 100, paint);

        canvas.drawPath(getLxPath(), paint);
//        if(mBitmap!=null){
//            canvas.drawBitmap(mBitmap,addY,addX,paint);
//        }


        paint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }

    int addY = 200;
    int addX = 200;

    public Path getLxPath() {
        int LxR = 100;
        int count = 5;
        Path mPath = new Path();
        mPath.moveTo(LxR + addX, 0 + addY);
        for (int i = 1; i < count; i++) {
            int angle = 360 / count * i;
            mPath.lineTo((float) (cos(angle) * LxR + addX), (float) (sin(angle) * LxR + addY));
        }
        return mPath;
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

    public void setTouchXY(float x, float y) {
        addX = (int) x-50;
        addY = (int) y-50;
        invalidate();
    }
}
