package com.example.administrator.cs301examples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import android.widget.TextView;

//sending data between activities video on google

public class MainActivity2 extends ActionBarActivity implements View.OnClickListener {

    TextView whatYouSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        whatYouSend = (TextView) findViewById(R.id.whatYouSend);

        Intent intent = this.getIntent();
        String a = intent.getStringExtra("testing");

    }


    @Override
    public void onClick(View v) {
        intent.putExtra("goback","yay");

        finish();

    }
}
