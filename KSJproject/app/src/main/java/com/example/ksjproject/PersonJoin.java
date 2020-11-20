package com.example.ksjproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class PersonJoin extends AppCompatActivity
{
    Button PJoinSubmit;
    EditText PJoinEdtId, PJoinEdtPwd, PJoinEdtPwdCheck, PJoinEdtName, PJoinEdtBirth, PJoinEdtEmail, PJoinEdtTel;
    RadioGroup PJoinRadioSexGroup;
    RadioButton PJoinRadioMale, PJoinRadioWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personjoin);

        PJoinSubmit = (Button) findViewById(R.id.PJoinSubmit);

        PJoinEdtId = (EditText) findViewById(R.id.PJoinEdtId);
        PJoinEdtPwd = (EditText) findViewById(R.id.PJoinEdtPwd);
        PJoinEdtPwdCheck = (EditText) findViewById(R.id.PJoinEdtPwdCheck);
        PJoinEdtName = (EditText) findViewById(R.id.PJoinEdtName);
        PJoinEdtBirth = (EditText) findViewById(R.id.PJoinEdtBirth);
        PJoinEdtEmail = (EditText) findViewById(R.id.PJoinEdtEmail);
        PJoinEdtTel = (EditText) findViewById(R.id.PJoinEdtTel);

        PJoinRadioSexGroup = (RadioGroup) findViewById(R.id.PJoinRadioSexGroup);

        PJoinRadioMale = (RadioButton) findViewById(R.id.PJoinRadioMale);
        PJoinRadioWoman = (RadioButton) findViewById(R.id.PJoinRadioWoman);

        PJoinSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                

            }
        });
    }
}
