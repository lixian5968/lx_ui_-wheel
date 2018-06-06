package com.lx.ui_wheel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ToWheel1(View v){
        ToActivity( Wheel2Activity.class);
    }

    public void ToActivity(Class mClass){
        startActivity(new Intent(MainActivity.this,mClass));
    }
}
