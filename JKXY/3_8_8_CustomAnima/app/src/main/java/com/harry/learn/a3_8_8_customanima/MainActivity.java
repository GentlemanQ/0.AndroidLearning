package com.harry.learn.a3_8_8_customanima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btnClickMe)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAnimation ca = new CustomAnimation();
                ca.setDuration(1000);
                v.startAnimation(ca);
            }
        });
    }
}
