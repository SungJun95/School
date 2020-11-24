package com.example.ksjproject.Person;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ksjproject.R;

public class PersonInfo extends AppCompatActivity {
    String id,password,name,birth,sex,email,tel;
    public PersonInfo(String id, String password, String name, String birth, String sex, String email, String tel){
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.email = email;
        this.tel = tel;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}