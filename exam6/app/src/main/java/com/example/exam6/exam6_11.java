package com.example.exam6;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class exam6_11 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam6_10);

        String[] items = { "CSI-뉴욕", "CSI-라스베가스", "CSi-마이애미", "Friends", "Fringe", "Lost" };

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);

        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();

        multi.setTokenizer(token);
        multi.setAdapter(adapter);
    }
}
