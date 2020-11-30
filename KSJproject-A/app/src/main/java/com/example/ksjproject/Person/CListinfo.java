package com.example.ksjproject.Person;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ksjproject.R;

public class CListinfo extends AppCompatActivity {

    public  String title, content, job, area, c_name, c_email, c_tel, number;

    public CListinfo(String title, String content, String job, String area, String c_name, String c_email, String c_tel, String number) {
        this.title = title;
        this.content = content;
        this.job = job;
        this.area = area;
        this.c_name = c_name;
        this.c_email = c_email;
        this.c_tel = c_tel;
        this.number = number;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_list_content);
    }
}
