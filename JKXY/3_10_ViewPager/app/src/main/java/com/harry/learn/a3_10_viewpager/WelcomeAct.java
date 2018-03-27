package com.harry.learn.a3_10_viewpager;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

/**
 * Created by Urbane on 2018/3/27.
 */

public class WelcomeAct extends Activity {
    private boolean isFirstRun = false;
    private static final int TIME = 2000;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        init();
    }

    private void init(){
        SharedPreferences preferences = getSharedPreferences("san11", MODE_PRIVATE);
        isFirstRun = preferences.getBoolean("isFirstRun", true);
        if(!isFirstRun){
            mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
        }else{
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstRun", false);
            editor.commit();
        }
    }

    private void goHome(){
        Intent i = new Intent(WelcomeAct.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goGuide(){
        Intent i = new Intent(WelcomeAct.this, Guide.class);
        startActivity(i);
        finish();
    }
}
