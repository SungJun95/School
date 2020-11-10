package com.example.exam11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class exam11_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam11_1);

        setTitle("리스트뷰 테스트임");

        final String[] mid = {"브레이킹배드", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크", "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이"};

        ListView list = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), mid[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}