package com.example.exam7;

import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class examTest7_3 extends AppCompatActivity {

    Button button1;
    EditText dlgEdtName, dlgEdtEmail , tvName, tvEmail;
    TextView toastText;
    View dialogView, toastView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examtest7_3);

        setTitle("사용자 정보 입력");

        tvName = (EditText) findViewById(R.id.tvName);
        tvEmail = (EditText) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = (View) View.inflate(examTest7_3.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(examTest7_3.this);

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.pig);
                dlg.setView(dialogView);

                dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                dlgEdtName.setText(tvName.getText());
                dlgEdtEmail.setText(tvEmail.getText());

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                 tvName.setText(dlgEdtName.getText().toString());
                                 tvEmail.setText(dlgEdtEmail.getText().toString());
                            }
                        });
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Display display = getWindowManager().getDefaultDisplay();
                                Point size = new Point();
                                display.getSize(size);

                                int xOffset = (int) (Math.random() * size.x);
                                int yOffset = (int) (Math.random() * size.y);

                                Toast toast = new Toast(examTest7_3.this);
                                toastView = (View) View.inflate(examTest7_3.this, R.layout.toast1, null);
                                toastText = (TextView) toastView.findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다");

                                toast.setView(toastView);

                                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset,yOffset);

                                toast.show();
                            }
                        });
                dlg.show();
            }
        });

    }


}
