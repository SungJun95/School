package com.example.exam14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class exam14_1 extends AppCompatActivity {

    Intent intent;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam14_1);
        setTitle("서비스 테스트 예제");

//        StartService 타입
//        1. 서비스시작,종료 버튼 레이아웃 구성하기
//        2. 매니패스트에 서비스 등록
//        3. 서비스 상속받아 나만의 서비스 클래스 만들기.
//        4. 매인액티비티에서 서비스 동작시키기.
//        5. 동작화면 및 결과


                            // 정보를받을 액티비티,  정보를 넘겨줄곳
        intent = new Intent(this, MusicService.class);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);   // 서비스 호출 메소드
                android.util.Log.i("서비스 테스트","StartService()");
                Toast myToast = Toast.makeText(getApplicationContext(),"시작해따", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);    // 서비스 중지 메소드
                android.util.Log.i("서비스 테스트","StopService()");
                Toast myToast = Toast.makeText(getApplicationContext(),"끝나따", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });


    }
}