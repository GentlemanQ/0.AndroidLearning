package com.harry.learn.a1_1_1_myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent i = getIntent();
        String strMessage = i.getStringExtra(MyActivity.MSG);
        ((TextView)findViewById(R.id.tv_show_message)).setTextSize(40);
        ((TextView)findViewById(R.id.tv_show_message)).setText(strMessage);
    }
}
