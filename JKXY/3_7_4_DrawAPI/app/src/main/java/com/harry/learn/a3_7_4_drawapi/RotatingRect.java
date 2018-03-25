package com.harry.learn.a3_7_4_drawapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Urbane on 2018/3/25.
 */

public class RotatingRect extends View {
    private Paint paint;
    private float degress = 1;

    public RotatingRect(Context context) {
        super(context);

        initProperties();
    }

    public RotatingRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initProperties();
    }

    public RotatingRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initProperties();
    }

    private void initProperties(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.save();
        canvas.translate(300, 300);
        canvas.rotate(degress, 100, 100);
        canvas.drawRect(0, 0, 200, 200, paint);

        degress++;
        canvas.restore();

        invalidate();
    }
}
