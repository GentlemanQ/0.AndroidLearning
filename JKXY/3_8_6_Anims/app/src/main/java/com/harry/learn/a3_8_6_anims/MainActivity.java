package com.harry.learn.a3_8_6_anims;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private AnimationSet as;
    private AlphaAnimation aa;
    private TranslateAnimation ta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        as = new AnimationSet(true);
        as.setDuration(3000);

        aa = new AlphaAnimation(0, 1);
        aa.setDuration(3000);
        aa.setAnimationListener(MainActivity.this);
        as.addAnimation(aa);

        ta = new TranslateAnimation(200, 0, 200, 0);
        ta.setDuration(3000);
//        ta.setAnimationListener(MainActivity.this);
        as.addAnimation(ta);



    }

    @Override
    protected void onResume() {
        super.onResume();

        ((Button)findViewById(R.id.btnClickMe)).startAnimation(as);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(MainActivity.this, "Animation End", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
