package com.example.exam6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class exam6test_2 extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper vFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam6test_2);

        // exam6_16
        btnPrev =  (Button) findViewById(R.id.btnPrev);
        btnNext =  (Button) findViewById(R.id.btnNext);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.setFlipInterval(15);
                vFlipper.startFlipping();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });

    }
}
