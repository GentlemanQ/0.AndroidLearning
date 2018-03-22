package com.harry.learn.a1_1_1_myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends AppCompatActivity {

    private Button btnSendMessage;
    public final static String MSG = "com.mycompany.myfirstapp.MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btnSendMessage = findViewById(R.id.btn_send);
    }

    public void sendMessage(View view){
        Intent i = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.edit_message);
        String strMessage = editText.getText().toString();
        i.putExtra(MSG, strMessage);
        startActivity(i);
    }
}
