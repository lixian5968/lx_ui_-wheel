package com.lx.ui_wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by lixian on 2017/4/13.
 */

public class LxRoundTopView extends RelativeLayout {


    private static final PorterDuffXfermode[] sModes = {
            new PorterDuffXfermode(PorterDuff.Mode.CLEAR),
            new PorterDuffXfermode(PorterDuff.Mode.SRC),
            new PorterDuffXfermode(PorterDuff.Mode.DST),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER),
            new PorterDuffXfermode(PorterDuff.Mode.DST_OVER),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_IN),
            new PorterDuffXfermode(PorterDuff.Mode.DST_IN),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT),
            new PorterDuffXfermode(PorterDuff.Mode.DST_OUT),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP),
            new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP),
            new PorterDuffXfermode(PorterDuff.Mode.XOR),
            new PorterDuffXfermode(PorterDuff.Mode.DARKEN),
            new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN),
            new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY),
            new PorterDuffXfermode(PorterDuff.Mode.SCREEN)
    };


    public LxRoundTopView(Context context) {
        super(context);
        init(context);
    }

    public LxRoundTopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LxRoundTopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    Paint paint;
    PorterDuffXfermode pdMode;
    float[] angles;

    private void init(Context context) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
//        int angle = (int) context.getResources().getDimension(R.dimen.Size3);
        int angle = 0;
        angles = new float[]{angle, angle, angle, angle, angle, angle, angle, angle};
        pdMode = sModes[0];
    }

    public void ChangeMode(int count) {
//        if (count >= sModes.length) {
//            count = count % sModes.length;
//        }
//        pdMode = sModes[count];
//        invalidate();
    }

    public void setMode(PorterDuffXfermode pdMode) {
        this.pdMode = pdMode;
        update = true;
        invalidate();
    }

    int left;
    int top;
    int right;
    int bottom;
    boolean update = false;

    public void setRoundRect(int left, int top, int right, int bottom, boolean update) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.update = update;
        invalidate();
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (update) {
            int saveCount = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint, Canvas.ALL_SAVE_FLAG);
            super.dispatchDraw(canvas);
            paint.setXfermode(pdMode);
            Path mPath = new Path();
            RectF roundRect = new RectF(left, top, right, bottom);
            mPath.addRoundRect(roundRect, angles, Path.Direction.CCW);
            canvas.drawPath(mPath, paint);
            canvas.restoreToCount(saveCount);
            paint.setXfermode(null);
        } else {
            super.dispatchDraw(canvas);
        }

    }


}
