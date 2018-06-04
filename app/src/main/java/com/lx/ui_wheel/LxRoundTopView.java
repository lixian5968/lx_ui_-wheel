package com.lx.ui_wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by lixian on 2017/4/13.
 */

public class LxRoundTopView extends FrameLayout {
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
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        int angle = (int) context.getResources().getDimension(R.dimen.Size3);
        angles = new float[]{angle, angle, angle, angle, angle, angle, angle, angle};
        pdMode = new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
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
