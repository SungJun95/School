package com.example.ksjproject.Person;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ksjproject.Adapter.PlistAdapter;
import com.example.ksjproject.R;
import com.example.ksjproject.network.NetworkGetPlist;

import java.util.ArrayList;

public class PersonMain extends AppCompatActivity {


    ListView Plistview;

    ArrayList<PListinfo> arrayList;

    PlistAdapter Padapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personmainpage);
        setTheme(android.R.style.Theme);


        Plistview = findViewById(R.id.Plistview);
        Padapter = new PlistAdapter(PersonMain.this, R.layout.adapter_jobinfo, new ArrayList<PListinfo>());
        Plistview.setAdapter(Padapter);






        Plistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 누른 아이템 content page로 이동 구현@@
            }
        });



        new NetworkGetPlist((PlistAdapter) Plistview.getAdapter()).execute("");
    }
}
