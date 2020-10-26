package com.example.exam6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class exam6_15 extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper vFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam6_15);

        // exam6_16
        btnPrev =  (Button) findViewById(R.id.btnPrev);
        btnNext =  (Button) findViewById(R.id.btnNext);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });

    }
}
