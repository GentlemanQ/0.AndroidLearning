package com.harry.learn.a3_8_8_customanima;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Urbane on 2018/3/25.
 */

public class CustomAnimation extends Animation {

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.getMatrix().setTranslate((float)(Math.sin(interpolatedTime * 20) * 50), 0);

        super.applyTransformation(interpolatedTime, t);
    }
}
