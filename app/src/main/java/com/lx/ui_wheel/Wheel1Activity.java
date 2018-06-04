package com.lx.ui_wheel;

import android.os.Bundle;

public class Wheel1Activity extends BaseActivity {

    LxRoundTopView mLxRoundTopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_wheel1);
        mLxRoundTopView = findViewById(R.id.mLxRoundTopView);

        mLxRoundTopView.setRoundRect((int)ct.getResources().getDimension(R.dimen.Size11),(int)ct.getResources().getDimension(R.dimen.Size390),
                WidthPixels-(int)ct.getResources().getDimension(R.dimen.Size11),(int)ct.getResources().getDimension(R.dimen.Size390)+(int)ct.getResources().getDimension(R.dimen.Size50),true);
    }
}
