package com.example.ksjproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyJoin extends AppCompatActivity
{
    Button CJoinSubmit;
    EditText CJoinEdtId, CJoinEdtPwd, CJoinEdtPwdCheck, CJoinEdtName, CJoinEdtCNumber, CJoinEdtEmail, CJoinEdtTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyjoin);

        CJoinSubmit = (Button) findViewById(R.id.PJoinSubmit);

        CJoinEdtId = (EditText) findViewById(R.id.CJoinEdtId);
        CJoinEdtPwd = (EditText) findViewById(R.id.CJoinEdtPwd);
        CJoinEdtPwdCheck = (EditText) findViewById(R.id.CJoinEdtPwdCheck);
        CJoinEdtName = (EditText) findViewById(R.id.CJoinEdtName);
        CJoinEdtCNumber = (EditText) findViewById(R.id.CJoinEdtCNumber);
        CJoinEdtEmail = (EditText) findViewById(R.id.CJoinEdtEmail);
        CJoinEdtTel = (EditText) findViewById(R.id.CJoinEdtTel);

//        CJoinSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }
}
