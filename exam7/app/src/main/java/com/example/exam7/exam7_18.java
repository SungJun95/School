package com.example.exam7;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exam7_18 extends AppCompatActivity {

    boolean[] checkArray = new boolean[] { false, false, false };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam7_18);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                final String[] versionArray = new String[] { "오레오", "파이", "큐(10)" };

                AlertDialog.Builder dlg = new AlertDialog.Builder(exam7_18.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMultiChoiceItems(versionArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked)
                            {
                                String str="";
                                int cnt=0;
                                for(int i=0; i<checkArray.length;++i)
                                {
                                    if(checkArray[i]) {
                                        cnt++;
                                        if(cnt != 1)
                                            str += ",";

                                        str += versionArray[i];
                                    }
                                }

                                if(cnt ==0)
                                    str ="선택없음";

                                button1.setText(str);
                            }
                        });
                dlg.setPositiveButton("닫기", null);
                dlg.show();

            }
        });
    }
}
