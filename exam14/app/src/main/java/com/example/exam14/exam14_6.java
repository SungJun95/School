package com.example.exam14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class exam14_6 extends AppCompatActivity {

    ImageView ivBattery;
    EditText edtBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam14_6);
        setTitle("빠떼리");

        ivBattery = (ImageView) findViewById(R.id.ivBattery);
        edtBattery = (EditText) findViewById(R.id.edtBattery);

    } // onCreate

    BroadcastReceiver br = new BroadcastReceiver() { // 브로드캐스트 객체 생성
        @Override
        public void onReceive(Context context, Intent intent) { // 파라미터 context, intent 받음 응답을받아 처리함
            String action = intent.getAction(); // 감지한 액션의 종류를 str으로

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) { // 액션이 배터리 체인지드 이면
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0); // 배터리의용량을 int 로 가져온다
                edtBattery.setText("현재 충전량 : " + remain + " \n");

                if (remain >= 90)
                    ivBattery.setImageResource(R.drawable.battery_100);
                else if (remain >= 70)
                    ivBattery.setImageResource(R.drawable.battery_80);
                else if (remain >= 50)
                    ivBattery.setImageResource(R.drawable.battery_60);
                else if (remain >= 10)
                    ivBattery.setImageResource(R.drawable.battery_20);
                else
                    ivBattery.setImageResource(R.drawable.battery_0);

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0); // 연결상태를 int로 가져온다

                switch (plug){ // 연결상태 switch문??
                    case 0:
                        edtBattery.append("전원 연결 : 안됨");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        edtBattery.append("전원 연결 : 어댑터 연결됨");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        edtBattery.append("전원 연결 : USB 연결됨");
                        break;
                } // switch
            } // if(action.equals)
        }   //onReceive
    }; // br

    @Override
    protected void onPause() { // onCreate의 메소드 (생명주기를 거치며 실행됨) , 잠시멈춘상태
        super.onPause();
        unregisterReceiver(br); // 브로드캐스트 등록해제
    }

    @Override
    // onCreate안에서 등록하지 않는 이유는 onCreate는 한번만 실행되기때문
    protected void onResume() { // onCreate의 메소드 (생명주기를 거치며 실행됨) , 다시실행될때
        super.onResume();
        IntentFilter iFilter = new IntentFilter(); // 여러인텐트중 필요한것을 거르기위한것
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED); // 인텐트 고르기
        registerReceiver(br, iFilter); // 브로드캐스트 등록
    }
}  // exam 14_6