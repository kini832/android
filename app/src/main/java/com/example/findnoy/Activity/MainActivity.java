package com.example.findnoy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findnoy.R;


public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
   // private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoginPage = new Intent(MainActivity.this, LogIn.class);
                startActivity(intentLoginPage);
            }
        });


    }

  }
