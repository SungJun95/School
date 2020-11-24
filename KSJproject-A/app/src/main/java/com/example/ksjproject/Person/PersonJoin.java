package com.example.ksjproject.Person;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ksjproject.R;
import com.example.ksjproject.network.NetworkPersonInsert;

public class PersonJoin extends AppCompatActivity
{
    Button PJoinSubmit;
    RadioButton PJoinRadioMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personjoin);



        PJoinSubmit = (Button) findViewById(R.id.PJoinSubmit);

        PJoinRadioMale = (RadioButton) findViewById(R.id.PJoinRadioMale);

        PJoinSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = ((EditText)findViewById(R.id.PJoinEdtPwd)).getText().toString();
                String passwordcheck = ((EditText)findViewById(R.id.PJoinEdtPwdCheck)).getText().toString();
                if(password.equals(passwordcheck)){ // 비밀번호 체크되면 ++ 빈칸체크도@@

                    String id = ((EditText)findViewById(R.id.PJoinEdtId)).getText().toString();
                    password = ((EditText)findViewById(R.id.PJoinEdtPwd)).getText().toString();
                    String name = ((EditText)findViewById(R.id.PJoinEdtName)).getText().toString();
                    String birth = ((EditText)findViewById(R.id.PJoinEdtBirth)).getText().toString();
                    String sex = (PJoinRadioMale.isChecked() ? "남자" : "여자");
                    String email = ((EditText)findViewById(R.id.PJoinEdtEmail)).getText().toString();
                    String tel = ((EditText)findViewById(R.id.PJoinEdtTel)).getText().toString();


                    new NetworkPersonInsert(PersonJoin.this).execute(id,password,name,birth,sex,email,tel);

                }
                else{
                    Toast myToast = Toast.makeText(PersonJoin.this,"비밀번호가 틀립니다.", Toast.LENGTH_SHORT);
                    myToast.show();
                }

            }
        });



    }

}
