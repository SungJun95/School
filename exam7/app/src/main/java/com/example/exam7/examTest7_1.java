package com.example.exam7;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class examTest7_1 extends AppCompatActivity {

    EditText Edit;
    ImageView img;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examtest7_1);

        setTitle("제주도사진보기");

        Edit = (EditText) findViewById(R.id.Edit);
        img = (ImageView) findViewById(R.id.img);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case R.id.imgRotate:
                int num = Integer.parseInt(String.valueOf(Edit.getText()));
                img.setRotation(num);
                return true;
            case R.id.item1:
                img.setImageResource(R.drawable.hanra);
                return true;
            case R.id.item2:
                img.setImageResource(R.drawable.chooja);
                return true;
            case R.id.item3:
                img.setImageResource(R.drawable.beom);
                return true;
        }
        return false;
    }
}
