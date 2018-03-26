package com.harry.learn.a3_8_1_layoutanimationinlinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout root = findViewById(R.id.ll);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(1000);

        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5f);//第二个参数表示动画间隔时间
        lac.setOrder(LayoutAnimationController.ORDER_REVERSE);//动画顺序

        root.setLayoutAnimation(lac);
    }
}
