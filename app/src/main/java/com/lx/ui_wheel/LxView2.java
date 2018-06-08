package com.lx.ui_wheel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class LxView2 extends View {
    public LxView2(Context context) {
        super(context);
        init(context, null);
    }

    public LxView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LxView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    float[] angles;
    private void init(Context context, AttributeSet attrs) {
        int angle = (int) context.getResources().getDimension(R.dimen.Size3);
        angles = new float[]{angle, angle, angle, angle, angle, angle, angle, angle};
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

        Path mPath = new Path();
        RectF roundRect = new RectF(0, 0, getWidth(), getHeight());
        mPath.addRoundRect(roundRect, angles, Path.Direction.CCW);
        canvas.drawPath(mPath, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }



}
