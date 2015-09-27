package com.example.administrator.cs301examples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button iNewPlayer;
    private Button goOn;

    private TextView oPlayerName;
    private TextView oPlayerStat1;

    private EditText iPlayerName;
    private EditText iPlayerStat1;

    private Spinner PlayerSpinner;

    private ArrayList<String> course;

    private HashMap<String, player> holder;
    private player p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course = new ArrayList<String>();
        course.add("Hi there");

        iNewPlayer = (Button) findViewById(R.id.iNewPlayer);
        goOn = (Button) findViewById(R.id.goOn);

        iPlayerName = (EditText) findViewById(R.id.iPlayerName);
        iPlayerStat1 = (EditText) findViewById(R.id.iPlayerStat1);

        oPlayerName = (TextView) findViewById(R.id.oPlayerName);
        oPlayerStat1 = (TextView) findViewById(R.id.oPlayerStat1);

        PlayerSpinner = (Spinner) findViewById(R.id.playerSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        PlayerSpinner.setAdapter(adapter);

        course.add("bob");

        p1 = new player();
        p1.name = "HI";
        p1.stat1 = "4";

        holder = new HashMap<String, player>();
        holder.put("Hi there", p1);

        iNewPlayer.setOnClickListener(this);
        PlayerSpinner.OnItemSelectedListener(this);


    }
    //deleted onCreateOptionsMenu and onCreateItemSelected

    public void onClick(View v) {
        if(v==iNewPlayer) {
            oPlayerName.setText("gottem");
            iPlayerName.getText() ;
            iPlayerStat1.getText() ;

            player pTemp = new player();
            pTemp.name = iPlayerName.getText().toString();
            pTemp.stat1 = iPlayerStat1.getText().toString();

            holder.put(iPlayerName.getText().toString(), pTemp);

            course.add(iPlayerName.getText().toString());
        }

        if(v==goOn){
            Intent intent = new Intent(this, MainActivity2.class);

            intent.putExtra("testing","this is my string");

            intent.putExtra("table", holder);

            //startActivity(intent);
            startActivityForResult(intent, 100);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(view == PlayerSpinner) {

            holder.get(PlayerSpinner.getSelectedItem().toString());
            oPlayerName.setText(pTemp.name);
            oPlayerStat1.setText(pTemp.stat1); //check Schmits code


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
