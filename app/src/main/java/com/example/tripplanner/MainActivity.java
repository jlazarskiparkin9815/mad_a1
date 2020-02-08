package com.example.tripplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // HELP BUTTON -------------------------------------------------------------------------
        Button helpButton = (Button) findViewById(R.id.button);
        helpButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });
        // HELP BUTTON -------------------------------------------------------------------------

        // BEGIN BUTTON -------------------------------------------------------------------------
        Button beginButton = (Button) findViewById(R.id.button2);
        beginButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, StartTripActivity.class));
            }
        });
        // BEGIN BUTTON -------------------------------------------------------------------------


    }
}
