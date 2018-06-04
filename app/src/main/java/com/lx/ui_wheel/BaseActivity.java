package com.lx.ui_wheel;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class BaseActivity extends AppCompatActivity {
    public int MetricsHeight;
    public float Density;
    public int WidthPixels;
    public Context ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ct =this;
        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        }
        WidthPixels = metrics.widthPixels;
        MetricsHeight = metrics.heightPixels;
        Density = metrics.density;
    }
}
