package com.henghao.gittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"dev:1");
        Log.i(TAG,"dev_zb:1");
        Log.i(TAG,"dev_zb:2");
        Log.i(TAG,"dev_zb:3");
        Log.i(TAG,"版本一上线");
        Log.i(TAG,"1.1");
        Log.i(TAG,"1.2");
        Log.i(TAG,"版本2上线");
        Log.i(TAG,"2.1");
        Log.i(TAG,"2.2");
        Log.i(TAG,"版本3上线");
        Log.i(TAG,"3.1");
    }
}
