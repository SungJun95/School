package com.example.ksjproject.Person;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ksjproject.Adapter.ClistAdapter;
import com.example.ksjproject.Adapter.PlistAdapter;
import com.example.ksjproject.R;
import com.example.ksjproject.network.NetworkGetContent;
import com.example.ksjproject.network.NetworkGetPlist;

import java.util.ArrayList;

public class PListContent extends AppCompatActivity {

    ListView Clistview;
    ClistAdapter Cadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_p_list_content);
        setContentView(R.layout.p_list_content);
        setTheme(android.R.style.Theme);


        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        Log.v("mango" , "PlistContent.java intent number : " + number);


        Clistview = findViewById(R.id.PcontentView);
        Cadapter = new ClistAdapter(PListContent.this, R.layout.activity_p_list_content, new ArrayList<CListinfo>());
        Clistview.setAdapter(Cadapter);

        new NetworkGetContent((ClistAdapter) Clistview.getAdapter()).execute(number);
    }
}