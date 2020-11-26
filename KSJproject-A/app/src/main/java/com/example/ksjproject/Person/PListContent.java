package com.example.ksjproject.Person;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ksjproject.R;

public class PListContent extends AppCompatActivity {

    ImageView PContentIV;
    Boolean IVboolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_list_content);


        int [] nDrawable = {R.drawable.heart1, R.drawable.heart2};

        IVboolean = false;
        PContentIV = (ImageView) findViewById(R.id.PContentIV);
        PContentIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IVboolean){
                    PContentIV.setImageResource(nDrawable[0]);
                    IVboolean=false;
                    Toast.makeText(getApplicationContext(), "찜하기해제!" , Toast.LENGTH_SHORT).show();
                    // DB에 찜하기 구현! 여유되면
                } else {
                    PContentIV.setImageResource(nDrawable[1]);
                    IVboolean=true;
                    Toast.makeText(getApplicationContext(), "찜했습니다!" , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}