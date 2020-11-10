package com.example.exam11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button exam11_1 , exam11_3 , exam11_4 , exam11_6, exam11_12, examtest11_2, exam11_16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exam11_1 = (Button) findViewById(R.id.exam11_1);
        exam11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam11_1Intent = new Intent(getApplicationContext(), exam11_1.class);
                startActivity(exam11_1Intent);
            }
        });

        exam11_3 = (Button) findViewById(R.id.exam11_3);
        exam11_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam11_3Intent = new Intent(getApplicationContext(), exam11_3.class);
                startActivity(exam11_3Intent);
            }
        });

        exam11_4 = (Button) findViewById(R.id.exam11_4);
        exam11_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam11_4Intent = new Intent(getApplicationContext(), exam11_4.class);
                startActivity(exam11_4Intent);
            }
        });

        exam11_6 = (Button) findViewById(R.id.exam11_6);
        exam11_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam11_6Intent = new Intent(getApplicationContext(), exam11_6.class);
                startActivity(exam11_6Intent);
            }
        });

        exam11_12 = (Button) findViewById(R.id.exam11_12);
        exam11_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam11_12Intent = new Intent(getApplicationContext(), exam11_12.class);
                startActivity(exam11_12Intent);
            }
        });

        examtest11_2 = (Button) findViewById(R.id.examtest11_2);
        examtest11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent examtest11_2Intent = new Intent(getApplicationContext(), examtest11_2.class);
                startActivity(examtest11_2Intent);
            }
        });

        exam11_16 = (Button) findViewById(R.id.exam11_16);
        exam11_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exam11_16Intent = new Intent(getApplicationContext(), exam11_16.class);
                startActivity(exam11_16Intent);
            }
        });
    }
}