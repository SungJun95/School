package com.example.exam14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button exam14_1, exam14_6, exam14_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exam14_1 = (Button) findViewById(R.id.exam14_1);
        exam14_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam14_1Intent = new Intent(getApplicationContext(), exam14_1.class);
                startActivity(exam14_1Intent);
            }
        });

        exam14_6 = (Button) findViewById(R.id.exam14_6);
        exam14_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam14_6Intent = new Intent(getApplicationContext(), exam14_6.class);
                startActivity(exam14_6Intent);
            }
        });

        exam14_10 = (Button) findViewById(R.id.exam14_10);
        exam14_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam14_10Intent = new Intent(getApplicationContext(), exam14_10.class);
                startActivity(exam14_10Intent);
            }
        });


    }
}