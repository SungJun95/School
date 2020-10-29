package com.example.exam7;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class exam7_12 extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam7_12);

        setTitle("토스트 만들기");

        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast tMsg = Toast.makeText(exam7_12.this, "토스트 연습", Toast.LENGTH_SHORT);

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                tMsg.setGravity((Gravity.TOP) | Gravity.LEFT, xOffset, yOffset);
                tMsg.show();
            }
        });

    }
}
