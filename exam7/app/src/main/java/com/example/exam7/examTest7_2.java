package com.example.exam7;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class examTest7_2 extends AppCompatActivity {

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
            menu.add(0, 1, 0, "배경색(빨강)");
            menu.add(0, 2, 0, "배경색(초록)");
            menu.add(0, 3, 0, "배경색(파랑)");
        }
        if (v == button2){
            menu.add(0,4,0,"버튼 45도 회전");
            menu.add(0,5,0,"버튼 2배 확대");
        }
    }
}
