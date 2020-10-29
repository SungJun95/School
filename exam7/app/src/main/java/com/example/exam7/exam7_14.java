package com.example.exam7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class exam7_14 extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam7_14);

        setTitle("대화상자 만들기");

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(exam7_14.this);
                dlg.setTitle("제목입니다.");
                dlg.setMessage("이곳이 내용입니다.");
                dlg.setIcon(R.mipmap.ic_launcher);
                // dlg.setPositiveButton("OKay", null);


                dlg.setPositiveButton("OKay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(exam7_14.this, "오케이하셨네요", Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.show();
            }
        });

    }
}
