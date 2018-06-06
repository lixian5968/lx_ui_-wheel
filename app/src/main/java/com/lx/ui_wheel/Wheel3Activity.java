package com.lx.ui_wheel;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

public class Wheel3Activity extends BaseActivity {


    LxView mLxView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_wheel3);
        mLxView = findViewById(R.id.mLxView);


        mLxView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mLxView.setTouchXY(event.getX(),event.getY());


                return true;
            }
        });
    }


}