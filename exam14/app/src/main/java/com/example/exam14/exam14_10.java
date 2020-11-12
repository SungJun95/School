package com.example.exam14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class exam14_10 extends AppCompatActivity {

    Button btnCall;
    EditText edtCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam14_10);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CALL_LOG}, MODE_PRIVATE);
        btnCall = (Button) findViewById(R.id.btnCall);
        edtCall = (EditText) findViewById(R.id.edtCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCall.setText(getCallHistory());
            }
        });
    }

    public String getCallHistory() {
        //1. 통화목록을 저장할 문자열 배열 준비 -> 처음에는 빈값
        String[] callset = new String[] {CallLog.Calls.DATE,
                                         CallLog.Calls.TYPE,
                                         CallLog.Calls.NUMBER,
                                         CallLog.Calls.DURATION};
        // 커서는 튜플을 가리키고있는 위치
        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI,
                                                callset,
                                            null,
                                            null,
                                            null);
        if(c == null)
            return "통화기록 없음";

        StringBuffer callBuff = new StringBuffer();
        callBuff.append("\n날짜 : 구분 : 전화번호 : 통화시간\n\n");

        c.moveToFirst(); // 커서를 첫번째 줄로 이동시킴
        do{
            //1번째줄 (=튜플(레코드)에서 컬럼별로 값을꺼내서 담기)
            long callDate = c.getLong(0);
            SimpleDateFormat datePattern = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = datePattern.format(new Date(callDate));
            callBuff.append(date_str + ":");
            if(c.getInt(1) == CallLog.Calls.INCOMING_TYPE)
                callBuff.append("착신 : ");
            else
                callBuff.append("발신 : ");
            callBuff.append(c.getString(2) + ":");
            callBuff.append(c.getString(3) + "초\n");
        } while (c.moveToNext());

        c.close();
        return callBuff.toString();
    }
}