package com.example.exam7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class exam7_18 extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam7_14);

        setTitle("대화상자 만들기");

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final String[] versionArray = new String[] {"오레오", "파이", "큐"};
                final boolean[] checkArray = new boolean[] {true , false , false};

                AlertDialog.Builder dlg = new AlertDialog.Builder(exam7_18.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                // dlg.setItems(versionArray,
//                   dlg.setSingleChoiceItems( versionArray , 0 ,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                button1.setText(versionArray[which]);
//                            }
//                        });
                    dlg.setMultiChoiceItems(versionArray, checkArray,
                            new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    button1.setText(versionArray[which]);
                                }
                            });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });

    }
}
