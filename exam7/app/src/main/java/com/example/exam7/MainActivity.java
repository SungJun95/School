package com.example.exam7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

Button btn7_1, btnTest7_1, btn7_7, btnTest7_2, btn7_12,btn7_14,btn7_18,btn7_21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn7_1 = (Button) findViewById(R.id.btn7_1);
        btn7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam7_1Intent = new Intent(MainActivity.this, exam7_1.class);
                startActivity(exam7_1Intent);
            }
        });

        btnTest7_1 = (Button) findViewById(R.id.btnTest7_1);
        btnTest7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent examTest7_1Intent = new Intent(MainActivity.this, examTest7_1.class);
                startActivity(examTest7_1Intent);
            }
        });

        btn7_7 = (Button) findViewById(R.id.btn7_7);
        btn7_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam7_7Intent = new Intent(MainActivity.this, exam7_7.class);
                startActivity(exam7_7Intent);
            }
        });

        btnTest7_2 = (Button) findViewById(R.id.btnTest7_2);
        btnTest7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent examTest7_2Intent = new Intent(MainActivity.this, examTest7_2.class);
                startActivity(examTest7_2Intent);
            }
        });

        btn7_12 = (Button) findViewById(R.id.btn7_12);
        btn7_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam7_12Intent = new Intent(MainActivity.this, exam7_12.class);
                startActivity(exam7_12Intent);
            }
        });

        btn7_14 = (Button) findViewById(R.id.btn7_14);
        btn7_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam7_14Intent = new Intent(MainActivity.this, exam7_14.class);
                startActivity(exam7_14Intent);
            }
        });

        btn7_18 = (Button) findViewById(R.id.btn7_18);
        btn7_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam7_18Intent = new Intent(MainActivity.this, exam7_18.class);
                startActivity(exam7_18Intent);
            }
        });

        btn7_21 = (Button) findViewById(R.id.btn7_21);
        btn7_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam7_21Intent = new Intent(MainActivity.this, exam7_21.class);
                startActivity(exam7_21Intent);
            }
        });
    }
}