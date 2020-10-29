package com.example.exam7;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class exam7_7 extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam7_7);

        setTitle("배경색 바꾸기(컨택스트 메뉴");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == button1){
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu3, menu);
        }
        if (v == button2){
            mInflater.inflate(R.menu.menu3_2, menu);
        }
    }
}
