package com.example.exam11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class exam11_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam11_4);

        setTitle("리스트뷰 테스트임");

        // 리스너에서 사용할 변수는 final을 달아줘야한다.
        final ArrayList<String> midList =  new ArrayList<>();
        ListView list = (ListView) findViewById(R.id.listView1);

        // context 란? Application 과 시스템의 전역적인 환경정보를 가지고 항시대기하는 친구
                                                            // 여기서 this는 자기자신인 액티비티를 말하는데
                                                            // 액티비티는 context의 자식이기 때문에 context에 해당할수있다.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        final EditText edtItem = (EditText) findViewById(R.id.ediItem);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midList.add(edtItem.getText().toString()); // EditText에 적은 value로 항목추가
                adapter.notifyDataSetChanged(); // 리스트에 추가한 항목을 갱신시켜주는 메소드 (약간F5같은 느낌?) , 새로추가된 하나만 갱신하는게아니고 다같이 갱신하기때문에 비효율
                                                // 재활용하는 리사이클러 뷰 라는게 있다.
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position); // 롱클릭된 리스트뷰 위치에 해당하는 항목 삭제
                adapter.notifyDataSetChanged(); // 갱신 again
                return false; // 연계용 불린 리턴
            }
        });

    }
}