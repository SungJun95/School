package com.example.exam11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class exam11_16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam11_16);

        setTitle("스피너 테스트");

        final String[] movie = { "쿵푸팬더", "짱구는 못말려", "아저씨", "아바타", "대부", "국가대표",
                "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유기" };

        final int []picName = {R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
                R.drawable.mov24, R.drawable.mov25, R.drawable.mov26, R.drawable.mov27,
                R.drawable.mov28, R.drawable.mov29, R.drawable.mov30};

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ImageView iv1 = (ImageView) findViewById(R.id.iv1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, movie); // 액티비티, 디자인, 데이터
        spinner.setAdapter(adapter); // 어뎁터 끼워주기

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iv1.setPadding(5,5,5,5);
                iv1.setImageResource(picName[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {  // 아무것도 선택되지 않았을때 null null

            }
        });
    }
}